package com.myprojects.pokidexiapp.login_registration.presentation.registration

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myprojects.pokidexiapp.R
import com.myprojects.pokidexiapp.core.presentation.MainToolbarView
import com.myprojects.pokidexiapp.utils.theme.ColorBlackDark
import com.myprojects.pokidexiapp.utils.theme.ColorBlackMedium
import com.myprojects.pokidexiapp.utils.theme.ColorBlueDark
import com.myprojects.pokidexiapp.utils.theme.ColorGreyLight
import com.myprojects.pokidexiapp.utils.theme.ColorGreyMedium
import com.myprojects.pokidexiapp.utils.theme.ColorWhite
import com.myprojects.pokidexiapp.utils.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailRegistrationPage(
  onNavigationClick: () -> Unit,
  onContinueClick: () -> Unit
) {
  var textFieldValue by rememberSaveable {
    mutableStateOf("")
  }
  val context = LocalContext.current
  Scaffold(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 40.dp),
    topBar = {
      MainToolbarView(
        toolbarTitle = context.getString(R.string.text_create_account),
        isNavigationEnabled = true,
        onNavigationClick = onNavigationClick
      )
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
        text = context.getString(R.string.text_email_reg_title),
        style = Typography.headlineLarge,
        color = ColorBlackMedium,
        textAlign = TextAlign.Center
      )
      Text(
        modifier = Modifier.fillMaxWidth(),
        text = context.getString(R.string.text_email_reg_desc),
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
          Text(
            text = context.getString(R.string.text_email_placeholder),
            style = Typography.labelLarge,
            color = ColorGreyMedium
          )
        },
        supportingText = {
          Text(
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 8.dp),
            text = context.getString(R.string.text_email_input_helper),
            style = Typography.labelSmall,
            color = ColorBlackMedium,
            textAlign = TextAlign.Center
          )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
          textColor = ColorBlackDark,
          unfocusedBorderColor = ColorGreyMedium,
          focusedBorderColor = ColorBlackDark
        ),
        singleLine = true,
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
          onClick = { onContinueClick() }) {
          Text(text = context.getString(R.string.text_continue), style = Typography.labelLarge)
        }
      }
    }
  }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_7")
@Composable
fun PreviewEmailRegistrationPage() {
  EmailRegistrationPage(onContinueClick = {}, onNavigationClick = {})
}