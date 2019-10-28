package com.iqbal.luaspersegipanjang.presenter

import com.iqbal.luaspersegipanjang.view.BaseView

interface BasePresenter <in A : BaseView> {
    fun onAttach(view: A)
    fun onDetach()
}