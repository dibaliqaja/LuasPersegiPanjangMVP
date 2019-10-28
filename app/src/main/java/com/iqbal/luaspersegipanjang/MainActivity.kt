package com.iqbal.luaspersegipanjang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iqbal.luaspersegipanjang.model.PPModel
import com.iqbal.luaspersegipanjang.presenter.MainPresenter
import com.iqbal.luaspersegipanjang.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        btn_hasil.onClick {
            presenter.hitung(edt_panjang.text.toString(), edt_lebar.text.toString())
        }
    }

    override fun isSuccess(hasil: PPModel) {
        alert {
            title = hasil.ppModel
            noButton { }
            yesButton { }
        }.show()
    }

    override fun isError() {
        toast("Di isi dulu Fieldnya gan...")
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        onDetachView()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDetachView()
    }

}