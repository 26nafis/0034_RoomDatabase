package com.example.roomdb.view.route

import com.example.roomdb.R
import com.example.roomdb.uicontroller.DestinasiNavigasi

object DestinasiEditSiswa : DestinasiNavigasi {
    const val itemIdArg = "itemId"
    override val route = "item_edit/{$itemIdArg}"
    override val titleRes = R.string.edit_siswa
    fun createRoute(id: Int) = "item_edit/$id"
}
