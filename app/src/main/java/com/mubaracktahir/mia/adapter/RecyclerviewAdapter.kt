package com.mubaracktahir.mia.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mubaracktahir.mia.R
import kotlinx.android.synthetic.main.item_view.view.*


/**
 * Created by Mubarak Tahir on 11/10/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

class RecyclerviewAdapter(val listener: (text: String) -> Unit) :
    RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>() {
    var notes = ArrayList<String>()
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount() = notes.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(notes[position], listener)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(note: String, listener: (text: String) -> Unit) {
            view.textview.text = note
            view.card_view.setOnClickListener {
                listener(note)
            }

        }
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_view, parent, false)
                return MyViewHolder(view)
            }
        }
    }
}