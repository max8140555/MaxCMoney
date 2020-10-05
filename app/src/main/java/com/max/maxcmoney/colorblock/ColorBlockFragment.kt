package com.max.maxcmoney.colorblock


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.max.maxcmoney.NavigationDirections
import com.max.maxcmoney.databinding.FragmentColorBlockBinding

class ColorBlockFragment : Fragment() {

    private lateinit var binding: FragmentColorBlockBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(requireActivity()).get(ColorBlockViewModel::class.java)

        binding = FragmentColorBlockBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerColorBlock.adapter = ColorBlockAdapter(ColorBlockAdapter.OnClickListener{
            findNavController().navigate(NavigationDirections.actionGlobalColorBlockDetailFragment(it))
        })

        return binding.root
    }

}