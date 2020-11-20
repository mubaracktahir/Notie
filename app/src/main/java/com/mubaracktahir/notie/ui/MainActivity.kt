package com.mubaracktahir.notie.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LifecycleObserver
import com.mubaracktahir.notie.R
import com.mubaracktahir.notie.databinding.ActivityMainBinding
import com.mubaracktahir.notie.ui.screens.notes.HomeFragment

class MainActivity : AppCompatActivity(), HomeFragment.ManageDrawer, LifecycleObserver {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setting content view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    /**
     * Initializing view and listeners
     * [initializeNavigationView]
     */
    fun init() {
        initializeNavigationView()
    }

    /**
     *
     *  setting up navigation View and DrawerLayout (that thing that is being swiped from the left)
     *
     */
    private fun initializeNavigationView() {

        listenForNavigationItemSelections()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.drawerLayout.setScrimColor(
                resources.getColor(
                    R.color.colorPrimaryDark,
                    this.theme
                )
            )
        } else {
            binding.drawerLayout.setScrimColor(resources.getColor(R.color.colorPrimaryDark))
        }

        binding.drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                val diffScaleOffset = slideOffset * (1 - 0.7f);
                val xOffSetScale = drawerView.width * slideOffset
                val xOffScaleDiff = binding.contentView.width * diffScaleOffset / 2
                val xTranslation = xOffSetScale - xOffScaleDiff
                binding.contentView.translationX = xTranslation

            }

            override fun onDrawerClosed(drawerView: View) {
            }

            override fun onDrawerOpened(drawerView: View) {
            }

        })

        binding.navigationDrawer.bringToFront()
        binding.navigationDrawer.setCheckedItem(R.id.all_notes)

    }
    /**
     *
     * when ever an item is selected in the navigationDrawer this function
     * [listenForNavigationItemSelections] is called
     *
     */
    private fun listenForNavigationItemSelections() {
        binding.navigationDrawer.setNavigationItemSelectedListener {
            val id = it.itemId
            when (id) {
                R.id.all_notes -> {
                    Toast.makeText(applicationContext, id, Toast.LENGTH_LONG).show()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    override fun openDrawerLayout() {
        if (binding.drawerLayout.isDrawerVisible(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else
            binding.drawerLayout.openDrawer(GravityCompat.START)
    }

}