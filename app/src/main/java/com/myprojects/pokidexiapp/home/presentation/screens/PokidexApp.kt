package com.myprojects.pokidexiapp.home.presentation.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.myprojects.pokidexiapp.R
import com.myprojects.pokidexiapp.home.presentation.model.PokidexScreens
import com.myprojects.pokidexiapp.home.presentation.navigation.HomeNavHost
import com.myprojects.pokidexiapp.utils.theme.ColorBlueDark
import com.myprojects.pokidexiapp.utils.theme.ColorWhite
import com.myprojects.pokidexiapp.utils.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokidexApp() {
  val context = LocalContext.current
  val navHostController = rememberNavController()
  val backStackEntry = navHostController.currentBackStackEntryAsState()
  val navBarItemsList = createBottomNavItemList(context)
  Surface(color = ColorWhite) {
    Scaffold(bottomBar = {
      NavigationBar(containerColor = ColorWhite, tonalElevation = 8.dp) {
        navBarItemsList.forEachIndexed { index, item ->
          NavigationBarItem(
            selected = backStackEntry.value?.destination?.route == item.route,
            onClick = {
              navHostController.navigate(item.route) {
                popUpTo(navHostController.graph.startDestinationId)
                launchSingleTop = true
              }
            },
            icon = {
              Image(
                painter = painterResource(
                  if (backStackEntry.value?.destination?.route == item.route) item.selectedIconId
                  else item.unselectedIconId
                ),
                contentDescription = ""
              )
            }, label = {
              Text(
                text = item.title,
                style = Typography.labelSmall,
                color = ColorBlueDark
              )
            },
            alwaysShowLabel = false
          )
        }
      }
    }
    ) {
      Column(Modifier.padding(it)) {
        HomeNavHost(navHostController = navHostController)
      }
    }
  }
}

fun createBottomNavItemList(context: Context) = listOf(
  NavigationBarItemData(
    index = 0,
    title = context.getString(R.string.title_nav_bar_item_one),
    selectedIconId = R.drawable.ic_pokedex_selected,
    unselectedIconId = R.drawable.ic_pokedex_unselected,
    route = PokidexScreens.HomeScreen.route
  ),
  NavigationBarItemData(
    index = 0,
    title = context.getString(R.string.title_nav_bar_item_two),
    selectedIconId = R.drawable.ic_regions_selected,
    unselectedIconId = R.drawable.ic_regions_unselected,
    route = PokidexScreens.RegionsScreen.route
  ),
  NavigationBarItemData(
    index = 0,
    title = context.getString(R.string.title_nav_bar_item_three),
    selectedIconId = R.drawable.ic_favourites_selected,
    unselectedIconId = R.drawable.ic_favourites_unselected,
    route = PokidexScreens.FavouritesScreen.route
  ),
  NavigationBarItemData(
    index = 0,
    title = context.getString(R.string.title_nav_bar_item_four),
    selectedIconId = R.drawable.ic_account_selected,
    unselectedIconId = R.drawable.ic_account_unselected,
    route = PokidexScreens.AccountScreen.route
  )
)

data class NavigationBarItemData(
  val index: Int,
  val title: String,
  val selectedIconId: Int,
  val unselectedIconId: Int,
  val route: String
)