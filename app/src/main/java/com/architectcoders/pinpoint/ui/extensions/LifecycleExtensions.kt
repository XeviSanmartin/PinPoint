package com.architectcoders.pinpoint.ui.extensions

import androidx.lifecycle.LifecycleCoroutineScope
import com.architectcoders.pinpoint.eventbus.EventBus
import com.architectcoders.pinpoint.ui.common.LoaderEvent
import kotlinx.coroutines.launch

fun LifecycleCoroutineScope.subscribeLoader(onEvent: (Boolean) -> Unit) {
    this.launch {
        EventBus.subscribe<LoaderEvent> { onEvent(it.shouldShowLoader) }
    }
}
