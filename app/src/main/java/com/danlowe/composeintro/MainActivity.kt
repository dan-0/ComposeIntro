package com.danlowe.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danlowe.composeintro.ui.theme.ComposeIntroTheme
import com.danlowe.composeintro.ui.views.HelloWorldText
import com.danlowe.composeintro.ui.views.KeysAreImportant
import com.danlowe.composeintro.ui.views.ModifierOrderMatters
import com.danlowe.composeintro.ui.views.SharedClicks
import com.danlowe.composeintro.ui.views.ShowAllDemoViews
import com.danlowe.composeintro.ui.views.StyledText

class MainActivity : ComponentActivity() {

  private val viewModel: IncrementingViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeIntroTheme {
        val viewModelState = viewModel.state.collectAsState()
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          ShowAllDemoViews(state = viewModelState)
        }
      }
    }
  }
}

@Preview
@Composable
fun PreviewShowAll() {
  val state = remember {
    mutableIntStateOf(1)
  }
  ComposeIntroTheme {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
      ShowAllDemoViews(state = state)
    }
  }
}