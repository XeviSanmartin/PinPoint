package com.architectcoders.pinpoint.ui.common

import com.architectcoders.pinpoint.eventbus.Event

data class LoaderEvent(val shouldShowLoader: Boolean) : Event
