package com.max.maxcmoney.colorblock.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.max.maxcmoney.databinding.FragmentColorBlockDetailBinding
import com.max.maxcmoney.network.VolleyService
import com.max.maxcmoney.util.Util

class ColorBlockDetailFragment : Fragment() {

    lateinit var binding: FragmentColorBlockDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentColorBlockDetailBinding.inflate(inflater, container, false)
        val photosArgs = ColorBlockDetailFragmentArgs.fromBundle(
            requireArguments()
        ).photosKey

        binding.photos = photosArgs

        val splitThumbnailUrl = Util.splitUrl(photosArgs.url, "/")

        binding.image.setImageUrl(
            "https://ipsumimage.appspot.com/${splitThumbnailUrl[3]},${splitThumbnailUrl[4]}",
            VolleyService.imageLoader
        )

        return binding.root
    }

}