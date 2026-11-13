package com.example.roomdb.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomdb.repositori.RepositoriSiswa
import com.example.roomdb.room.Siswa

class EntryViewModel(
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set






}










