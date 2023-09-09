package com.myprojects.pokidexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.myprojects.pokidexapp.ui.screens.RegistrationPage
import com.myprojects.pokidexapp.ui.theme.PokidexAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      PokidexAppTheme {
        RegistrationPage()
      }
    }
  }
}