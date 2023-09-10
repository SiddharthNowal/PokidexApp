package com.myprojects.pokidexiapp.login_registration.presentation.google_sign_in

data class GoogleSignInState (
  val isSignSuccessful: Boolean = false,
  val errorMessage: String? = null
)