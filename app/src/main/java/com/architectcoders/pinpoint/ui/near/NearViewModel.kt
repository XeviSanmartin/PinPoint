package com.architectcoders.pinpoint.ui.near

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class NearViewModel constructor(
    private val currentLocationUseCase: GetCurrentLocationUseCase = GetCurrentLocationUseCase(),
    private val nearListUseCase: GetNearListUseCase = GetNearListUseCase()
) : ViewModel() {

    private val _currentLocation = MutableStateFlow(LocationUiModel.default)
    val currentLocation: StateFlow<LocationUiModel> = _currentLocation

    private var _nearList = MutableStateFlow<List<LocationUiModel>>(listOf())
    val nearList: StateFlow<List<LocationUiModel>> = _nearList

    init {
        viewModelScope.launch {
            _currentLocation.value =
                currentLocationUseCase
                    .invoke()
                    .getOrDefault(LocationUiModel.default)
            nearListUseCase.invoke().collect {
                _nearList.value = it
            }
        }
    }
}

data class LocationUiModel(
    val lat: Double,
    val long: Double,
    val name: String,
    val description: String = ""
) {
    companion object {
        val default = LocationUiModel(0.0, 0.0, "")
    }
}

fun LocationUiModel.toLatLng(): LatLng =
    LatLng(lat, long)

class GetCurrentLocationUseCase {

    suspend operator fun invoke(): Result<LocationUiModel> {
        return Result.success(LocationUiModel(41.404042, 2.185080, "You are here"))
    }
}

class GetNearListUseCase {

    suspend operator fun invoke(): Flow<List<LocationUiModel>> =
        flow {
            emit(
                listOf(
                    LocationUiModel(41.404042, 2.175080, "Sagrada familia"),
                    LocationUiModel(41.390951, 2.186579, "Parc de la ciutadella")
                )
            )
        }
}
