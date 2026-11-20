package com.example.roomdb.view.route

import com.example.roomdb.R
import com.example.roomdb.uicontroller.DestinasiNavigasi

object DestinasiDetailSiswa : DestinasiNavigasi {
    const val itemIdArg = "itemId"
    override val route = "item_detail/{$itemIdArg}"
    override val titleRes = R.string.detail_siswa

    fun createRoute(id: Int) = "item_detail/$id"
}
