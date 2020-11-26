package com.mubaracktahir.notie.utils


/**
 * Created by Mubarak Tahir on 11/25/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
sealed class DataState<out T> {

    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val error: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()

}