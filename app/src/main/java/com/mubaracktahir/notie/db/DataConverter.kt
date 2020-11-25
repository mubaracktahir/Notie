package com.mubaracktahir.notie.db


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.mubaracktahir.notie.db.Entity.NoteEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class DataConverter {

    @TypeConverter
    fun listToJson(value: List<String>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

  /*  @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): List<String>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, NoteEntity::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(objects: List<String>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, NoteEntity::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        return adapter.toJson(objects)
    }*/

}