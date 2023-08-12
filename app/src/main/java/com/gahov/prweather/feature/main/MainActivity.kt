package com.gahov.prweather.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gahov.prweather.R
import com.gahov.prweather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setupBinding()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView<ActivityMainBinding?>(
            this, R.layout.activity_main
        )
            .also { it.lifecycleOwner = this }
    }
}