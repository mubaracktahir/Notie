package com.mubaracktahir.notie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mubaracktahir.notie.R
import com.mubaracktahir.notie.databinding.InfoLayoutBinding
import com.mubaracktahir.notie.models.Note
import kotlinx.android.synthetic.main.todo_list_layout.view.*


/**
 * Created by Mubarak Tahir on 11/10/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

const val TODO_LIST = 1
const val INFO_NOTE = 2

class RecyclerviewAdapter(val listener: (text: String) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * the list of items that this adapter uses to display item on the [RecyclerView]
     */
    var notes = ArrayList<Note>()
        set(value) {
            field = value

            /**
             *
             * this tells the the [RecyclerView] that the list has been updated
             * this will make every item on the list to be redrawn.
             *
             */
            notifyDataSetChanged()
        }

    /**
     * part of the recycler Adapter called when [RecyclerView] needs a new [ViewHolder]
     *
     * the [ViewHolder] holds a view for the [RecyclerView]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == TODO_LIST)
            TodoViewHolder.from(parent)
        else
            InfoViewHolder.from(parent)
    }


    /**
     * @param position this is the current item index
     *
     * This function [getItemViewType] is use to logically know the kind of item coming from the
     * [notes] in other to know the expected layout to inflate
     */

    override fun getItemViewType(position: Int): Int {
        return if (notes[position].isTodo)
            TODO_LIST
        else
            INFO_NOTE
    }

    /**
     * @return the size of the all the [notes].
     */
    override fun getItemCount() = notes.size

    /**
     * @param holder is the viewholder of each item, it could either be [TodoViewHolder] or
     * [InfoViewHolder]
     *
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TODO_LIST) {
            val todoViewHolder = holder as TodoViewHolder
            todoViewHolder.bind("", listener)
        } else {
            val infoViewHolder = holder as InfoViewHolder
            infoViewHolder.bind(notes[position], listener)
        }

    }


    /**
     *
     * The InfoViewHolder class
     *
     */
    class InfoViewHolder(val binding: InfoLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note, listener: (text: String) -> Unit) {
            binding.note = note
            binding.executePendingBindings()
            binding.cardView.setOnClickListener {
                listener(note.description)
            }
        }

        companion object {
            fun from(parent: ViewGroup): InfoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = InfoLayoutBinding.inflate(layoutInflater, parent, false)
                return InfoViewHolder(view)
            }
        }
    }

    class TodoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(note: String, listener: (text: String) -> Unit) {
            view.card_view.setOnClickListener {
                listener(note)
            }
        }

        companion object {
            fun from(parent: ViewGroup): TodoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.todo_list_layout, parent, false)
                return TodoViewHolder(view)
            }
        }
    }
}