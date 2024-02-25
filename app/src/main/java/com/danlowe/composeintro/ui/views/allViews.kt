package com.danlowe.composeintro.ui.views

import android.widget.ImageView
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.danlowe.composeintro.IncrementingViewModel

@Composable
fun ShowAllDemoViews(state: State<Int>) {
  val sharedClickCount = rememberSaveable {
    mutableIntStateOf(0)
  }

  LazyColumn {

    // basic text
    item("just text") {
      HelloWorldText()
    }

    // text with styling
    item("styled text") {
      StyledText()
    }

    // Box with modifiers
    item("modifiers") {
      ModifierOrderMatters()
    }

    // button to increment counter
    item("counter") {
      CounterButton()
    }

    item("sharedClicks1") {
      SharedClicks(
        id = "1",
        sharedClickCount = sharedClickCount.intValue
      ) {
        sharedClickCount.intValue = sharedClickCount.intValue + 1
      }
    }

    item("sharedClicks2") {
      SharedClicks(
        id = "2",
        sharedClickCount = sharedClickCount.intValue
      ) {
        sharedClickCount.intValue = sharedClickCount.intValue + 1
      }
    }

    // collecting from a flow as state, use another incrementer
    item("increment from VM") {
      ReadStateFromViewModel(state.value)
    }


    // count down timer
    item("keys are important") {
      KeysAreImportant()
    }


    // wrap an AndroidView
    item("interop") {
      Interop()
    }

    item("spacer") {
      Spacer(modifier = Modifier.height(100.dp))
    }
  }
}

@Composable
fun Interop() {
  val text = rememberSaveable {
    mutableStateOf("Hello from an Android _View_")
  }
  Column(
    modifier = Modifier.fillMaxWidth().background(Color.White)
  ) {
    AndroidView(
      factory = { context ->
        TextView(context)
          .apply { this.text = "No update implemented: ${text.value}" }
      }
    )
    AndroidView(
      factory = { context ->
        TextView(context)
          .apply { this.text = "Update implemented: ${text.value}" }
      },
      update = { textView ->
        textView.text = "Update implemented: ${text.value}"
      }
    )

    BasicTextField(
      modifier = Modifier.fillMaxWidth(),
      textStyle = MaterialTheme.typography.headlineMedium,
      value = text.value,
      onValueChange = { text.value = it }
    )
  }
}