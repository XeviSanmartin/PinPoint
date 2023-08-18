package com.architectcoders.pinpoint.ui.detail

data class DetailUiModel(
    val urlImage: String,
    val title: String,
    val subtitle: String? = null,
    val coord: String? = null,
    val description: String? = null
)
