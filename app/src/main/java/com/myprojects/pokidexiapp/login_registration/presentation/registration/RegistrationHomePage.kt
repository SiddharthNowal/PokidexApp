@file:OptIn(ExperimentalMaterial3Api::class)

package com.myprojects.pokidexiapp.login_registration.presentation.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myprojects.pokidexiapp.R
import com.myprojects.pokidexiapp.core.presentation.MainToolbarView
import com.myprojects.pokidexiapp.utils.theme.ColorBlackDark
import com.myprojects.pokidexiapp.utils.theme.ColorBlackLow
import com.myprojects.pokidexiapp.utils.theme.ColorBlackMedium
import com.myprojects.pokidexiapp.utils.theme.ColorBlueDark
import com.myprojects.pokidexiapp.utils.theme.ColorWhite
import com.myprojects.pokidexiapp.utils.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationHomePage(
  onNavigationClick: () -> Unit,
  registerWithGoogleClick: () -> Unit,
  registerWithEmailClick: () -> Unit
) {
  val context = LocalContext.current
  Scaffold(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 40.dp),
    topBar = {
      MainToolbarView(toolbarTitle = context.getString(R.string.text_create_account), isNavigationEnabled = true, onNavigationClick = { onNavigationClick() })
    }
  ) {
    Column(
      modifier = Modifier
        .padding(it)
        .background(color = ColorWhite)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Image(
        modifier = Modifier.padding(top = 40.dp),
        contentScale = ContentScale.Fit,
        painter = painterResource(id = R.drawable.illustration_registration_page),
        contentDescription = "Illustration Registration Page"
      )
      Text(
        modifier = Modifier.padding(top = 24.dp),
        text = context.getString(R.string.text_reg_home_title),
        style = Typography.headlineLarge,
        textAlign = TextAlign.Center,
        color = ColorBlackDark
      )
      Text(
        modifier = Modifier.padding(top = 16.dp, bottom = 32.dp),
        text = context.getString(R.string.text_reg_home_desc),
        style = Typography.labelMedium,
        textAlign = TextAlign.Center,
        color = ColorBlackLow
      )
      Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
        OutlinedButton(
          modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
          onClick = { registerWithGoogleClick() }) {
          Image(
            painter = painterResource(id = R.drawable.ic_google_icon),
            contentDescription = "Google Icon",
            contentScale = ContentScale.Inside
          )
          Text(
            modifier = Modifier.padding(start = 16.dp),
            text = context.getString(R.string.text_continue_with_google),
            style = Typography.labelLarge,
            color = ColorBlackMedium
          )
        }
        Button(
          modifier = Modifier
            .padding(top = 12.dp)
            .height(56.dp)
            .fillMaxWidth(),
          colors = ButtonDefaults.buttonColors(containerColor = ColorBlueDark),
          onClick = { registerWithEmailClick() }) {
          Text(text = context.getString(R.string.text_continue_with_email), style = Typography.labelLarge)
        }
      }
    }
  }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_7")
@Composable
fun PreviewRegistrationPage() {
  RegistrationHomePage({}, {}, {})
}