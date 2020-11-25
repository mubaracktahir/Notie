package com.mubaracktahir.notie.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mubaracktahir.notie.db.Entity.NoteEntity
import com.mubaracktahir.notie.db.dao.NoteDao
import com.mubaracktahir.notie.utils.Constants.DATABASE_NAME


/**
 * Created by Mubarak Tahir on 11/21/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

@Database(entities = [NoteEntity::class], version = 2)
@TypeConverters(DataConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao
    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        DATABASE_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}