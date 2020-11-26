package com.mubaracktahir.notie.repo

import com.mubaracktahir.notie.db.Entity.DataBaseEntitymapper
import com.mubaracktahir.notie.db.NoteDatabase
import com.mubaracktahir.notie.db.dao.NoteDao
import javax.inject.Inject


/**
 * Created by Mubarak Tahir on 11/25/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class MainRepo constructor(
    val noteDao: NoteDao,
    val dataBaseEntitymapper: DataBaseEntitymapper
) {
    fun getAllNote() = noteDao.getAllNotes()
}