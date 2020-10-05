package com.max.maxcmoney.util


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max.maxcmoney.colorblock.ColorBlockAdapter
import com.max.maxcmoney.data.Photos

@BindingAdapter("colorBlockItems")
fun bindRecyclerViewWithColorBlockItems(recyclerView: RecyclerView, photosItems: List<Photos>?) {
    photosItems?.let {

        recyclerView.adapter?.apply {
            when (this) {
                is ColorBlockAdapter -> {
                    submitList(it)
                }
            }
        }
    }
}

