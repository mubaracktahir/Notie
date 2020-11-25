package com.mubaracktahir.notie.db.Entity

import androidx.room.*
import com.mubaracktahir.notie.db.DataConverter


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */


@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "is_todo") val isTodo: Boolean = false,
    @ColumnInfo(name = "description") val description: String = "des",
    @ColumnInfo(name = "todo_list") val todoList: List<String>? = arrayListOf(),
    @ColumnInfo(name = "date") val date: Long = System.currentTimeMillis()
)