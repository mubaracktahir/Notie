package com.mubaracktahir.notie.db.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */


@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey val id: Long = 0L,
    @ColumnInfo(name = "is_todo") val isTodo: Boolean,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "todo_list") val todoList: ArrayList<String>? = arrayListOf(),
    @ColumnInfo(name = "date") val date: Long = System.currentTimeMillis()
)