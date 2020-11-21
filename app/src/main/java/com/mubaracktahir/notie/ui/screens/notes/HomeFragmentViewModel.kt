package com.mubaracktahir.notie.ui.screens.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.d
import com.mubaracktahir.notie.models.Note


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class HomeFragmentViewModel : ViewModel() {
    private val _noteChanged = MutableLiveData<Boolean>()
    val noteChanged: LiveData<Boolean> get() = _noteChanged
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
        _noteChanged.value = true
    }

    init {
        _noteChanged.value = false
    }
}