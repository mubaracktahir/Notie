package com.mubaracktahir.notie.db.Entity

import com.mubaracktahir.notie.models.Note
import com.mubaracktahir.notie.utils.Mapper
import javax.inject.Inject


/**
 * Created by Mubarak Tahir on 11/24/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class DataBaseEntitymapper @Inject constructor() : Mapper<NoteEntity, Note> {
    override fun fromEntityToDomainModel(entityModel: NoteEntity): Note {
        return Note(
            id = entityModel.id,
            description = entityModel.description,
            isTodo = entityModel.isTodo,
            todoList = entityModel.todoList,
            date = entityModel.date
        )
    }

    override fun fromDomainModelToEntity(domainModel: Note): NoteEntity {
        return NoteEntity(
            id = domainModel.id,
            description = domainModel.description,
            isTodo = domainModel.isTodo,
            todoList = domainModel.todoList,
            date = domainModel.date
        )
    }

    fun mapFromEntityList(noteEntities: List<NoteEntity>): List<Note> {
        return noteEntities.map { fromEntityToDomainModel(it) }
    }

    fun mapFromDomainList(noteEntities: List<Note>): List<NoteEntity> {
        return noteEntities.map { fromDomainModelToEntity(it) }
    }
}