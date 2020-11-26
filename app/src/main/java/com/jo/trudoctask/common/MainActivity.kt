package com.jo.trudoctask.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.jo.trudoctask.R
import com.jo.trudoctask.list.domain.model.Business
import com.jo.trudoctask.list.presentation.view.BusinessListFragment
import com.jo.trudoctask.list.presentation.view.BusinessListFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}