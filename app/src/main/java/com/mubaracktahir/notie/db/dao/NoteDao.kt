package com.mubaracktahir.notie.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mubaracktahir.notie.db.Entity.NoteEntity


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

@Dao
interface NoteDao {

    @Insert
    fun insert(note: NoteEntity)

    @Update
    fun update(note: NoteEntity)

    @Query("SELECT * FROM note_table WHERE id = :id  ")
    fun getNote(id: Long): NoteEntity?

    @Delete
    fun deleteAllNotes(note: List<NoteEntity>): Int

    @Query("DELETE FROM note_table ")
    fun clear()

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    fun getAllNotes() : LiveData<List<NoteEntity>>
}