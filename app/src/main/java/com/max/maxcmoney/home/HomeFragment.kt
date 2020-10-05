package com.max.maxcmoney.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.max.maxcmoney.NavigationDirections
import com.max.maxcmoney.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.buttonRequestApi.setOnClickListener {
            findNavController().navigate(NavigationDirections.actionGlobalColorBlockFragment())
        }

        return binding.root
    }

}