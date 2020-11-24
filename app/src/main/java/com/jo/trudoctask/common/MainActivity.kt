package com.jo.trudoctask.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jo.trudoctask.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}