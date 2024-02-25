package com.danlowe.composeintro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class IncrementingViewModel : ViewModel() {
  private val _state = MutableStateFlow(0)
  val state: StateFlow<Int> get() = _state

  init {
    viewModelScope.launch(Dispatchers.IO) {
      while (true) {
        _state.value = _state.value + 1
        delay(1000)
      }
    }
  }
}