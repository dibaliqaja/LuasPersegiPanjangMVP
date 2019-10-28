package com.iqbal.luaspersegipanjang.presenter

import com.iqbal.luaspersegipanjang.model.PPModel
import com.iqbal.luaspersegipanjang.view.MainView

class MainPresenter (model : MainView?) : BasePresenter<MainView> {

    private var modelView : MainView? = model

    fun hitung (panjang : String, lebar : String) {
        if (panjang.isNotEmpty() && lebar.isNotEmpty()) {
            val p = panjang.toDouble()
            val l = lebar.toDouble()
            val luas = p * l
            val model = PPModel(luas.toString())

            modelView?.isSuccess(model)
        } else {
            modelView?.isError()
        }
    }

    override fun onAttach(view: MainView) {
        modelView = view
    }

    override fun onDetach() {
        modelView = null
    }

}