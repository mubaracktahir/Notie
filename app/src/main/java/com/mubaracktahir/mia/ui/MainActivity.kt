package com.mubaracktahir.mia.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mubaracktahir.mia.R
import com.mubaracktahir.mia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setting content view
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
    }
}