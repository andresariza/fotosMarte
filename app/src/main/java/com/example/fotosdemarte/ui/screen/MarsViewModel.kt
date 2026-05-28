package com.example.fotosdemarte.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fotosdemarte.network.MarPhoto
import com.example.fotosdemarte.network.MarsApi
import kotlinx.coroutines.launch
import java.io.IOException

class MarsViewModel : ViewModel() {
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        viewModelScope.launch {
            try {

                marsUiState = MarsUiState.Success(MarsApi.retrofitService.getPhotos())
            } catch (e: IOException) {
                marsUiState = MarsUiState.Error
            }
        }
    }
}

sealed interface MarsUiState{
    data class Success(val photos: List<MarPhoto>):MarsUiState
    object Error:MarsUiState
    object Loading:MarsUiState

}