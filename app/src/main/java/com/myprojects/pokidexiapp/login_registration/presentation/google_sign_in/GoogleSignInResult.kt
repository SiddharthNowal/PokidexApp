package com.myprojects.pokidexiapp.login_registration.presentation.google_sign_in

data class GoogleSignInResult(
  val googleUserData: UserData? = null,
  val errorMessage: String? = null
)

data class UserData(
  val userName: String?,
  val userId: String,
  val profileImageUrl: String?
)