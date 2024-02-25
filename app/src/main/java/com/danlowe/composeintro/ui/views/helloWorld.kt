package com.danlowe.composeintro.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.danlowe.composeintro.R

@Composable
fun HelloWorldText() {
  Text(stringResource(R.string.hello_world))
}