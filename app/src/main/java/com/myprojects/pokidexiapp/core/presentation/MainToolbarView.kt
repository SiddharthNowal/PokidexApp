package com.myprojects.pokidexiapp.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myprojects.pokidexiapp.R
import com.myprojects.pokidexiapp.utils.theme.ColorBlackDark
import com.myprojects.pokidexiapp.utils.theme.ColorWhite
import com.myprojects.pokidexiapp.utils.theme.Typography

@Composable
fun MainToolbarView(
  toolbarTitle: String,
  isNavigationEnabled: Boolean = false,
  onNavigationClick: () -> Unit = {}
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .background(color = ColorWhite, shape = RectangleShape)
      .height(48.dp)
  ) {
    if (isNavigationEnabled) {
      Image(
        modifier = Modifier
          .clickable { onNavigationClick() }
          .align(Alignment.CenterVertically),
        painter = painterResource(id = R.drawable.ic_navigation_back),
        contentDescription = "Naviagtion Button"
      )
    }
    Text(
      modifier = Modifier
        .align(Alignment.CenterVertically)
        .fillMaxWidth(),
      text = toolbarTitle,
      style = Typography.bodyLarge,
      textAlign = TextAlign.Center,
      color = ColorBlackDark
    )
  }
}

@Preview
@Composable
fun PreviewMainToolbarView() {
  MainToolbarView(toolbarTitle = "Title", isNavigationEnabled = true) {

  }
}