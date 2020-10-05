package com.max.maxcmoney.colorblock

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max.maxcmoney.data.Photos
import com.max.maxcmoney.databinding.ItemColorBlockBinding
import com.max.maxcmoney.network.VolleyService
import com.max.maxcmoney.util.Util


class ColorBlockAdapter(
    private val onClickListener: OnClickListener
) :
    ListAdapter<Photos, ColorBlockAdapter.ColorBlockViewHolder>(
        DiffCallback
    ) {

    class ColorBlockViewHolder(private var binding: ItemColorBlockBinding) :
        RecyclerView.ViewHolder(binding.root) {
        
        @SuppressLint("SetTextI18n")
        fun bind(photos: Photos) {
            binding.photos = photos

            val splitThumbnailUrl = Util.splitUrl(photos.thumbnailUrl,"/")
            binding.image.setImageUrl(
                "https://ipsumimage.appspot.com/${splitThumbnailUrl[3]},${splitThumbnailUrl[4]}",
                VolleyService.imageLoader)

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Photos>() {
        override fun areItemsTheSame(
            oldItem: Photos,
            newItem: Photos
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Photos,
            newItem: Photos
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ColorBlockViewHolder {
        return ColorBlockViewHolder(
            ItemColorBlockBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ColorBlockViewHolder, position: Int) {
        val photos = getItem(position)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(photos)
        }
        holder.bind(photos)
    }

    class OnClickListener(val clickListener: (photos: Photos) -> Unit) {
        fun onClick(photos: Photos) = clickListener(photos)
    }
}