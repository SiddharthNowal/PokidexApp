package com.myprojects.pokidexapp.LoginAndRegistration.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myprojects.pokidexapp.core.presentation.MainToolbarView
import com.myprojects.pokidexapp.utils.theme.ColorBlackDark
import com.myprojects.pokidexapp.utils.theme.ColorBlackMedium
import com.myprojects.pokidexapp.utils.theme.ColorBlueDark
import com.myprojects.pokidexapp.utils.theme.ColorGreyLight
import com.myprojects.pokidexapp.utils.theme.ColorGreyMedium
import com.myprojects.pokidexapp.utils.theme.ColorWhite
import com.myprojects.pokidexapp.utils.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailRegistrationPage() {
  var textFieldValue by rememberSaveable {
    mutableStateOf("")
  }
  Scaffold(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 40.dp),
    topBar = {
      MainToolbarView(toolbarTitle = "Create Account", isNavigationEnabled = true)
    }
  ) {
    Column(
      modifier = Modifier
        .padding(it)
        .fillMaxSize()
        .background(ColorWhite),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        modifier = Modifier
          .padding(top = 48.dp)
          .fillMaxWidth(),
        text = "Let's get started!",
        style = Typography.headlineLarge,
        color = ColorBlackMedium,
        textAlign = TextAlign.Center
      )
      Text(
        modifier = Modifier.fillMaxWidth(),
        text = "What is your email?",
        style = Typography.headlineLarge,
        color = ColorBlackDark,
        textAlign = TextAlign.Center
      )
      OutlinedTextField(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 24.dp),
        value = textFieldValue,
        onValueChange = { value ->
          textFieldValue = value
        },
        textStyle = Typography.labelLarge,
        shape = TextFieldDefaults.outlinedShape,
        placeholder = {
          Text(text = "E-mail", style = Typography.labelLarge, color = ColorGreyMedium)
        },
        supportingText = {
          Text(
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 8.dp),
            text = "Please use a valid email address.",
            style = Typography.labelSmall,
            color = ColorBlackMedium,
            textAlign = TextAlign.Center
          )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
          textColor = ColorBlackDark,
          unfocusedBorderColor = ColorGreyMedium,
          focusedBorderColor = ColorBlackDark
        )
      )
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Button(
          enabled = textFieldValue.isNotBlank(),
          modifier = Modifier
            .padding(top = 12.dp)
            .height(56.dp)
            .fillMaxWidth(),
          colors = ButtonDefaults.buttonColors(
            containerColor = ColorBlueDark,
            disabledContainerColor = ColorGreyLight,
            disabledContentColor = ColorGreyMedium
          ),
          onClick = { /*TODO*/ }) {
          Text(text = "Continue", style = Typography.labelLarge)
        }
      }
    }
  }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_7")
@Composable
fun PreviewEmailRegistrationPage() {
  EmailRegistrationPage()
}