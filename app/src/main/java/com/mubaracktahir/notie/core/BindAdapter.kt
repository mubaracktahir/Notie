package com.mubaracktahir.notie.core

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mubaracktahir.notie.models.Note


/**
 * Created by Mubarak Tahir on 11/20/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

@BindingAdapter("text")
fun TextView.setInfoText(note: Note) {
    note?.let {
        this.text = note.description
    }
}