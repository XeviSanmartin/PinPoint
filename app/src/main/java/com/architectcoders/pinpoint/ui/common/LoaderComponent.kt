package com.architectcoders.pinpoint.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.architectcoders.pinpoint.R
import com.architectcoders.pinpoint.ui.theme.semiWhite

@Composable
fun LoaderComponent() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loader))

    LottieAnimation(
        modifier = Modifier
            .fillMaxSize()
            .background(semiWhite)
            .clickable { }, // Avoids click propagation
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}