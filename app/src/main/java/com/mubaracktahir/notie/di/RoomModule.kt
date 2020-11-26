package com.mubaracktahir.notie.di

import android.content.Context
import androidx.room.Room
import com.mubaracktahir.notie.db.NoteDatabase
import com.mubaracktahir.notie.db.dao.NoteDao
import com.mubaracktahir.notie.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


/**
 * Created by Mubarak Tahir on 11/25/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.noteDao
    }
}