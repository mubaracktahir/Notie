package com.mubaracktahir.notie.ui.screens

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


/**
 * Created by Mubarak Tahir on 11/25/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainNavHostFrament : NavHostFragment() {
    @Inject
    lateinit var homeFragmentViewModelFactory: MainFragmentViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = homeFragmentViewModelFactory
    }

}