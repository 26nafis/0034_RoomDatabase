package com.example.roomdb.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.repositori.RepositoriSiswa
import com.example.roomdb.view.route.DestinasiEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiEntry.itemIdArg])

    private val _uiStateSiswa = MutableStateFlow(DetailSiswaUiState())
    val uiStateSiswa: StateFlow<DetailSiswaUiState> = _uiStateSiswa.asStateFlow()

    init {
        viewModelScope.launch {
            repositoriSiswa.getSiswaStream(idSiswa).collect { siswa ->
                if (siswa != null) _uiStateSiswa.value = DetailSiswaUiState(siswa.toDetailSiswa())
            }
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        _uiStateSiswa.value = DetailSiswaUiState(detailSiswa)
    }

    suspend fun updateSiswa() {
        repositoriSiswa.updateSiswa(_uiStateSiswa.value.detailSiswa.toSiswa())
    }

    suspend fun deleteSiswa() {
        repositoriSiswa.deleteSiswa(_uiStateSiswa.value.detailSiswa.toSiswa())
    }
}

data class DetailSiswaUiState(
    val detailSiswa: DetailSiswa = DetailSiswa()
)