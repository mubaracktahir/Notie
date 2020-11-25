package com.mubaracktahir.notie.utils


/**
 * Created by Mubarak Tahir on 11/24/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
interface Mapper<EntityModel, DomainModel> {
    fun fromEntityToDomainModel(entityModel: EntityModel): DomainModel
    fun fromDomainModelToEntity(domainModel: DomainModel): EntityModel
}