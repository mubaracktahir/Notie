package com.mubaracktahir.notie.models


/**
 * Created by Mubarak Tahir on 11/18/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

/*
*
*
* this is the data class for the note model
*
*
* */
data class Note(
    val id: Long,
    val isTodo: Boolean,
    val description: String,
    val todoList: ArrayList<String>? = arrayListOf(),
    val date: String
)