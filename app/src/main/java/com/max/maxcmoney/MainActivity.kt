package com.max.maxcmoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.max.maxcmoney.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        navController = findNavController(R.id.myNavHostFragment)

        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            when (nd.id) {
                R.id.homeFragment -> {
                    binding.buttonBack.visibility = View.INVISIBLE
                }
                R.id.colorBlockFragment->{
                    binding.buttonBack.visibility = View.VISIBLE
                }
                R.id.colorBlockDetailFragment->{
                    binding.buttonBack.visibility = View.VISIBLE
                }
            }
        }

        binding.buttonBack.setOnClickListener {
            navController.navigateUp()
        }
    }

}