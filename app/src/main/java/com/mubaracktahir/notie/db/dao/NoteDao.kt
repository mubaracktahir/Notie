package com.mubaracktahir.notie.db.dao

import android.os.FileObserver.DELETE
import androidx.lifecycle.LiveData
import androidx.room.*
import com.mubaracktahir.notie.db.Entity.Note


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Query("SELECT * FROM note_table WHERE id = :id  ")
    fun getNote(id: Long): Note

    @Delete
    fun deleteAllNotes(note: List<Note>): Int

    @Query("DELETE FROM note_table ")
    fun clear()

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    fun getAllNotes() : LiveData<List<Note>>

}