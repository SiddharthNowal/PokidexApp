package com.myprojects.pokidexiapp.login_registration.presentation.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity
import com.myprojects.pokidexiapp.home.presentation.activity.HomeActivity
import com.myprojects.pokidexiapp.login_registration.presentation.google_sign_in.GoogleAuthSignInClient
import com.myprojects.pokidexiapp.login_registration.presentation.google_sign_in.GoogleSignInViewModel
import com.myprojects.pokidexiapp.login_registration.presentation.registration.EmailRegistrationPage
import com.myprojects.pokidexiapp.login_registration.presentation.registration.PasswordRegistrationPage
import com.myprojects.pokidexiapp.login_registration.presentation.registration.RegistrationHomePage
import com.myprojects.pokidexiapp.utils.theme.PokidexAppTheme
import kotlinx.coroutines.launch

class LoginAndRegistrationActivity : ComponentActivity() {

  private val viewModel: GoogleSignInViewModel by viewModels()

  private val googleAuthSignInClient by lazy {
    GoogleAuthSignInClient(
      context = this,
      oneTapClient = Identity.getSignInClient(this)
    )
  }

  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      PokidexAppTheme {
        val navHostController = rememberNavController()
        if (googleAuthSignInClient.getSignedInUser() != null) {
          startActivity(Intent(this, HomeActivity::class.java))
        }
        NavHost(navController = navHostController, startDestination = "register_home") {
          composable(route = "register_home") {
            val loginState = viewModel.loginState.collectAsState()
            val googleSignInLauncher =
              rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                  result.data?.let {
                    if (result.resultCode == RESULT_OK) {
                      lifecycleScope.launch {
                        val signInResult = googleAuthSignInClient.signInWithIntent(
                          it
                        )
                        viewModel.onSignInResult(signInResult)
                      }
                    } else {
                      val exception = result.data?.getSerializableExtra(
                        ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, Exception::class.java)
                      exception?.printStackTrace()
                    }
                  }
                })
            LaunchedEffect(key1 = loginState.value.isSignSuccessful) {
              if(loginState.value.isSignSuccessful) {
                Toast.makeText(
                  this@LoginAndRegistrationActivity, "Google Sign-In Successful", Toast.LENGTH_LONG
                ).show()
                startActivity(Intent(this@LoginAndRegistrationActivity, HomeActivity::class.java))
                viewModel.resetState()
              } else {
                Toast.makeText(
                  this@LoginAndRegistrationActivity, "Error", Toast.LENGTH_LONG
                ).show()
              }
            }
            RegistrationHomePage(
              onNavigationClick = {
                 navHostController.navigateUp()
              },
              registerWithEmailClick = {
              navHostController.navigate("email_reg") {
                launchSingleTop = true
              }
            }, registerWithGoogleClick = {
              lifecycleScope.launch {
                val googleSignIn = googleAuthSignInClient.signIn()
                googleSignIn?.let {
                  try {
                    googleSignInLauncher.launch(
                      IntentSenderRequest.Builder(it).build()
                    )
                  } catch (e: Exception) {
                    e.printStackTrace()
                  }
                }
              }
            })
          }
          composable("email_reg") {
            EmailRegistrationPage(onNavigationClick = {
              navHostController.navigateUp()
            }, onContinueClick = {
              navHostController.navigate("pass_reg") {
                launchSingleTop = true
              }
            })
          }
          composable("pass_reg") {
            PasswordRegistrationPage(onNavigationClick = {
              navHostController.navigateUp()
            })
          }
        }
      }
    }
  }
}