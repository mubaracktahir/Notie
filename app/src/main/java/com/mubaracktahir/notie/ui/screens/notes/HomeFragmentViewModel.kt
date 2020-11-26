package com.mubaracktahir.notie.ui.screens.notes

import android.app.Application
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.github.ajalt.timberkt.d
import com.mubaracktahir.notie.db.Entity.NoteEntity
import com.mubaracktahir.notie.repo.MainRepo
import kotlinx.coroutines.*
import javax.inject.Inject


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class HomeFragmentViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val mainRepo: MainRepo
) :
    ViewModel() {

    private val _noteChanged = MutableLiveData<Boolean>()
    val noteChanged: LiveData<Boolean> get() = _noteChanged

    private val _list = MutableLiveData<List<NoteEntity>>()
    val list: LiveData<List<NoteEntity>> get() = _list

    lateinit var notes: LiveData<List<NoteEntity>>

    val job = Job()

    val uiScope = CoroutineScope(Dispatchers.Main + job)

    init {
        _noteChanged.value = true
        //notes = dataBase.getAllNotes()
        //loadNote()
    }

    fun createNewNote() {
        uiScope.launch {
            insertNote(
                NoteEntity(
                    isTodo = true,
                    description = "Hello, What will you like for lunch?",
                    todoList = arrayListOf(),
                    date = 10000
                )
            )
        }
        _noteChanged.value = true
    }

    val mappper = mainRepo.getAllNote()

    private suspend fun insertNote(note: NoteEntity) {

        return withContext(Dispatchers.IO) {
            // dataBase.insert(note)
            d {
                "inserted successfully"
            }
        }
    }

    private fun loadNote() {
        uiScope.launch {
            _list.value = fetch().value ?: return@launch
            _noteChanged.value = true
        }
    }

    suspend fun fetch(): LiveData<List<NoteEntity>> {
        return withContext(Dispatchers.IO) {

            TODO("")
            //  dataBase.getAllNotes()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}

sealed class MainStateEvent {
    object GetNoteEvents : MainStateEvent()
    object None : MainStateEvent()
}