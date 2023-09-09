package com.myprojects.pokidexapp.LoginAndRegistration.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.myprojects.pokidexapp.LoginAndRegistration.presentation.RegistrationPage
import com.myprojects.pokidexapp.utils.theme.PokidexAppTheme

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