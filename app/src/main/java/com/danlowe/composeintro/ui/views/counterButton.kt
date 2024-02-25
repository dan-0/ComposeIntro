package com.danlowe.composeintro.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CounterButton() {
  val count = remember {
    mutableIntStateOf(0)
  }
  val saveableCount = rememberSaveable {
    mutableIntStateOf(0)
  }
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text("Count ${count.intValue}")
    Text("Saved Count ${saveableCount.intValue}")
    Button(
      onClick = {
        count.intValue = count.intValue + 1
        saveableCount.intValue = saveableCount.intValue + 1
      }
    ) {
      Icon(
        Icons.Outlined.Add,
        contentDescription = "Add"
      )
    }
  }
}