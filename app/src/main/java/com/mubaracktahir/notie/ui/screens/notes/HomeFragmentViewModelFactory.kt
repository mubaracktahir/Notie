package com.mubaracktahir.notie.ui.screens.notes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mubaracktahir.notie.db.dao.NoteDao


/**
 * Created by Mubarak Tahir on 11/24/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class HomeFragmentViewModelFactory(val context: Application, val noteDao: NoteDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java))
        return HomeFragmentViewModel(context,noteDao) as T
        throw IllegalArgumentException("UnKnown view Model Class ")

    }
}