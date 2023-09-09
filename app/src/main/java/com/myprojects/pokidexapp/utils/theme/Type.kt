package com.myprojects.pokidexapp.utils.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.myprojects.pokidexapp.R

private val poppinsFontFamily = FontFamily(
  Font(R.font.poppins_regular, FontWeight.Normal),
  Font(R.font.poppins_medium, FontWeight.Medium),
  Font(R.font.poppins_light, FontWeight.Light)
)

// Set of Material typography styles to start with
val Typography = Typography(
  bodyLarge = TextStyle(
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 18.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  headlineLarge = TextStyle(
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 26.sp,
    lineHeight = 39.sp,
    letterSpacing = 0.sp
  ),
  titleLarge = TextStyle(
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp
  ),
  labelLarge = TextStyle(
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  labelMedium = TextStyle(
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    letterSpacing = 0.5.sp
  ),
  labelSmall = TextStyle(
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
  )
)