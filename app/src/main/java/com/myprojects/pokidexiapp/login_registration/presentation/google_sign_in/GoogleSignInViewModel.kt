package com.myprojects.pokidexiapp.login_registration.presentation.google_sign_in

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GoogleSignInViewModel : ViewModel() {

  private val _loginState = MutableStateFlow(GoogleSignInState())
  val loginState = _loginState.asStateFlow()

  fun onSignInResult(result: GoogleSignInResult) {
    _loginState.update {
      it.copy(
        isSignSuccessful = result.googleUserData != null,
        errorMessage = result.errorMessage
      )
    }
  }

  fun resetState() {
    _loginState.update { GoogleSignInState() }
  }
}