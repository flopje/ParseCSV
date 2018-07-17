package com.flowapps.parseCSV.presentation.view.adapter

import androidx.databinding.BindingAdapter
import android.view.View

object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("showHide")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if(show) View.VISIBLE else View.GONE
    }
}
