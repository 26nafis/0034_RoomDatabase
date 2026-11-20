package com.example.roomdb.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdb.R
import com.example.roomdb.view.route.DestinasiDetailSiswa
import com.example.roomdb.uicontroller.SiswaTopAppBar
import com.example.roomdb.viewmodel.DetailViewModel
import com.example.roomdb.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailSiswaScreen(
    navigateBack: () -> Unit,
    onEditClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val state by viewModel.uiStateSiswa.collectAsState()
    val scope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { SiswaTopAppBar(stringResource(DestinasiDetailSiswa.titleRes), true, scrollBehavior = scrollBehavior, navigateUp = navigateBack) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(20.dp).verticalScroll(rememberScrollState()).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(state.detailSiswa.nama, style = MaterialTheme.typography.headlineSmall)
            Text("Alamat: ${state.detailSiswa.alamat}")
            Text("Telepon: ${state.detailSiswa.telpon}")
            Button(onClick = { onEditClick(state.detailSiswa.id) }) { Text("Edit") }
            Button(onClick = { scope.launch { viewModel.deleteSiswa(); navigateBack() } }) { Text("Hapus") }
        }
    }
}
