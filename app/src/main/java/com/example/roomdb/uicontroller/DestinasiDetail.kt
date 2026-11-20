package com.example.roomdb.uicontroller

import com.example.roomdb.R

object DestinasiDetail : DestinasiNavigasi {
    const val itemIdArg = "itemId"
    override val route = "item_detail/{$itemIdArg}"
    override val titleRes = R.string.app_name

    fun createRoute(itemId: Int): String = "item_detail/$itemId"
}
