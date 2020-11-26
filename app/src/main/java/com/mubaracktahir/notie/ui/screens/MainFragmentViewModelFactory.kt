package com.mubaracktahir.notie.ui.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.mubaracktahir.notie.ui.screens.notes.HomeFragment
import javax.inject.Inject


/**
 * Created by Mubarak Tahir on 11/24/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

class MainFragmentViewModelFactory @Inject constructor() : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            HomeFragment::class.java.name -> {
                HomeFragment()
            }
            else -> super.instantiate(classLoader, className)
        }

    }

}