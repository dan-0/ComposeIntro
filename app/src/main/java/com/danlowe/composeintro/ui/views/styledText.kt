package com.danlowe.composeintro.ui.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle

@Composable
fun StyledText() {
  Text(
    text = "Hello styled world!",
    style = MaterialTheme.typography.headlineLarge,
    fontStyle = FontStyle.Italic
  )
}