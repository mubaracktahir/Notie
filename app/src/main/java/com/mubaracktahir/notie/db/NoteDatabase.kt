package com.mubaracktahir.notie.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mubaracktahir.notie.db.Entity.NoteEntity
import com.mubaracktahir.notie.db.dao.NoteDao


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

@Database(entities = [NoteEntity::class], version = 2)
@TypeConverters(DataConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}