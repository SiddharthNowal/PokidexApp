package com.myprojects.pokidexiapp.login_registration.presentation.google_sign_in

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.myprojects.pokidexiapp.R
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException

class GoogleAuthSignInClient(
  private val context: Context,
  private val oneTapClient: SignInClient
) {

  private val firebaseAuth = Firebase.auth

  suspend fun signIn(): IntentSender? {
    val result =
      try {
        oneTapClient.beginSignIn(generateSignInRequest()).await()
      } catch (e: Exception) {
        e.printStackTrace()
        if (e is CancellationException) throw e
        null
      }
    return result?.pendingIntent?.intentSender
  }

  suspend fun signInWithIntent(intent: Intent): GoogleSignInResult {
    val credential = oneTapClient.getSignInCredentialFromIntent(intent)
    val googleIdToken = credential.googleIdToken
    val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)
    return try {
      firebaseAuth.signInWithCredential(googleCredentials).await().user?.let {
        GoogleSignInResult(
          googleUserData = UserData(
            userId = it.uid,
            userName = it.displayName,
            profileImageUrl = it.photoUrl?.toString()
          )
        )
      } ?: run {
        GoogleSignInResult()
      }
    } catch (e: Exception) {
      e.printStackTrace()
      e.printStackTrace()
      if (e is CancellationException) throw e
      GoogleSignInResult(
        errorMessage = e.message
      )
    }
  }

  fun getSignedInUser() = firebaseAuth.currentUser?.let {
    UserData(
      userName = it.displayName,
      userId = it.uid,
      profileImageUrl = it.photoUrl?.toString()
    )
  }

  suspend fun signOut() {
    try {
      oneTapClient.signOut().await()
      firebaseAuth.signOut()
    } catch (e: Exception) {
      e.printStackTrace()
      if (e is CancellationException) throw e
    }
  }

  private fun generateSignInRequest() =
    BeginSignInRequest.builder().setGoogleIdTokenRequestOptions(
      BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
        .setSupported(true)
        .setServerClientId(context.getString(R.string.firebase_client_id))
        .setFilterByAuthorizedAccounts(false)
        .build()
    ).build()
}