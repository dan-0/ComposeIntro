package com.danlowe.composeintro.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun KeysAreImportant() {
  val searchQuery = remember {
    mutableStateOf("")
  }

  val unitKeyDispatchedQuery = remember {
    mutableStateOf("")
  }

  val searchQueryKeyDispatched = remember {
    mutableStateOf("")
  }

  val searchQueryValueKeyDispatched = remember {
    mutableStateOf("")
  }

  LaunchedEffect(Unit) {
    delay(300)
    unitKeyDispatchedQuery.value = searchQuery.value
  }

  LaunchedEffect(searchQuery) {
    delay(300)
    searchQueryKeyDispatched.value = searchQuery.value
  }

  LaunchedEffect(searchQuery.value) {
    delay(300)
    searchQueryValueKeyDispatched.value = searchQuery.value
  }

  Column {
    Text("Unit key value: ${unitKeyDispatchedQuery.value}")
    Text("searchQuery key value: ${searchQueryKeyDispatched.value}")
    Text("searchQuery.value key value: ${searchQueryValueKeyDispatched.value}")
    Box(
      modifier = Modifier
        .background(MaterialTheme.colorScheme.onSurface)
        .fillMaxWidth()
    ) {
      BasicTextField(
        value = searchQuery.value,
        onValueChange = {
          searchQuery.value = it
        },
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp, vertical = 16.dp)
          .border(1.dp, Color.Black, CircleShape)
      )
    }
  }
}