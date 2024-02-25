package com.danlowe.composeintro.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ReadStateFromViewModel(viewModelState: Int) {
  Text("Current VM state: $viewModelState")
}