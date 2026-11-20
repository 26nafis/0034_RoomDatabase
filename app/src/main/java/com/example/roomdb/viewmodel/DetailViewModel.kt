package com.example.roomdb.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.repositori.RepositoriSiswa
import com.example.roomdb.uicontroller.DestinasiEntry
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiEntry.itemIdArg])

    val uiStateSiswa: StateFlow<DetailSiswaUiState> =
        repositoriSiswa.getSiswaStream(idSiswa)
            .filterNotNull()
            .map { DetailSiswaUiState(it.toDetailSiswa()) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailSiswaUiState()
            )




}

