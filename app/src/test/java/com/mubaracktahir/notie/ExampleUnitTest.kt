package com.mubaracktahir.notie

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.mubaracktahir.notie.db.Entity.NoteEntity
import com.mubaracktahir.notie.db.NoteDatabase
import com.mubaracktahir.notie.db.dao.NoteDao
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */





class ExampleUnitTest {

    lateinit var noteDao: NoteDao
    lateinit var noteDatabase: NoteDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        noteDatabase = Room.inMemoryDatabaseBuilder(context, NoteDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        noteDao = noteDatabase.noteDao

    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        noteDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun insert() {
        val note = NoteEntity()
        noteDao.insert(note)
        val note_d = noteDao.getNote(0)
        assertEquals(note_d?.description, "des")
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}