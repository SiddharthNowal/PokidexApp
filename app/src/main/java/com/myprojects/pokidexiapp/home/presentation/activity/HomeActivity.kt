package com.myprojects.pokidexiapp.home.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.myprojects.pokidexiapp.R
import com.myprojects.pokidexiapp.home.presentation.navigation.HomeNavHost
import com.myprojects.pokidexiapp.home.presentation.screens.PokidexApp
import com.myprojects.pokidexiapp.utils.theme.ColorBlueDark
import com.myprojects.pokidexiapp.utils.theme.ColorWhite
import com.myprojects.pokidexiapp.utils.theme.PokidexAppTheme
import com.myprojects.pokidexiapp.utils.theme.Typography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      PokidexAppTheme {
        PokidexApp()
      }
    }
  }
}