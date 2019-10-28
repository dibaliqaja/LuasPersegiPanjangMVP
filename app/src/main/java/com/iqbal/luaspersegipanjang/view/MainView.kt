package com.iqbal.luaspersegipanjang.view

import com.iqbal.luaspersegipanjang.model.PPModel

interface MainView : BaseView {
    fun isSuccess(hasil : PPModel)
    fun isError()
}