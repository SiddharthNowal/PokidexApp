package com.myprojects.pokidexiapp.home.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myprojects.pokidexiapp.R
import com.myprojects.pokidexiapp.core.presentation.MainToolbarView
import com.myprojects.pokidexiapp.utils.theme.PokidexAppTheme

class HomeActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      PokidexAppTheme {
        Scaffold(modifier = Modifier.padding(
          start = 16.dp,
          end = 16.dp,
          top = 24.dp,
          bottom = 40.dp
        ),
          topBar = {
            MainToolbarView(
              toolbarTitle = getString(R.string.text_create_account),
              isNavigationEnabled = true
            )
          }
        ) {
          Column(
            Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
          ) {
            Text(text = "Hello World")
          }
        }
      }
    }
  }
}