package com.mubaracktahir.notie.ui.screens.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mubaracktahir.notie.models.Note


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class HomeFragmentViewModel : ViewModel() {

    val arrayList = ArrayList<Note>()
    fun createNewNote() {
        arrayList.add(
            Note(
                isTodo = false,
                description = "Hello, What will you like for lunch?",
                todoList = arrayListOf(),
                date = "23:00"
            )
        )
        arrayList.add(
            Note(
                isTodo = true,
                description = "Hello, What will you like for lunch?",
                todoList = arrayListOf(),
                date = "23:00"
            )
        )
    }
}