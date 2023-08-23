package com.architectcoders.pinpoint.ui.near

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun NearScreen(viewModel: NearViewModel = NearViewModel()) {
    val currentLocation: LocationUiModel by viewModel.currentLocation.collectAsState()
    val nearList: List<LocationUiModel> by viewModel.nearList.collectAsState()

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLocation.toLatLng(), 12f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = currentLocation.toLatLng()),
            title = currentLocation.name
        )
        nearList.forEach {
            Marker(
                state = MarkerState(position = it.toLatLng()),
                title = it.name
            )
        }
    }
}
