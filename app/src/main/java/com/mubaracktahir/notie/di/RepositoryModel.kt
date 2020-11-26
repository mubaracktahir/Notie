package com.mubaracktahir.notie.di

import com.mubaracktahir.notie.db.Entity.DataBaseEntitymapper
import com.mubaracktahir.notie.db.dao.NoteDao
import com.mubaracktahir.notie.repo.MainRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


/**
 * Created by Mubarak Tahir on 11/25/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModel {

    @Provides
    @Singleton
    fun provideRepo(noteDao: NoteDao, dataBaseEntitymapper: DataBaseEntitymapper): MainRepo {
        return MainRepo(
            noteDao, dataBaseEntitymapper = dataBaseEntitymapper
        )
    }
}