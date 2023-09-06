package com.architectcoders.pinpoint.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.architectcoders.pinpoint.eventbus.EventBus
import com.architectcoders.pinpoint.ui.common.CategoryItemUiModel
import com.architectcoders.pinpoint.ui.common.LoaderEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _categories = MutableStateFlow<List<CategoryItemUiModel>>(listOf())
    val categories: StateFlow<List<CategoryItemUiModel>> = _categories

    init {
        viewModelScope.launch {
            EventBus.publish(LoaderEvent(true))
            delay(2000L)
            EventBus.publish(LoaderEvent(false))
        }

        _categories.value = listOf(
            CategoryItemUiModel(1, "", "Cities"),
            CategoryItemUiModel(2, "", "Restaurants"),
            CategoryItemUiModel(3, "", "Monuments"),
            CategoryItemUiModel(4, "", "Discos"),
        )
    }
}

private fun <T> MutableSharedFlow<T>.emitInScope(viewModel: ViewModel, value: T) {
    viewModel.viewModelScope.launch {
        this@emitInScope.emit(value)
    }
}
