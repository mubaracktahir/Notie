package com.mubaracktahir.mia.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mubaracktahir.mia.R
import com.mubaracktahir.mia.adapter.RecyclerviewAdapter
import com.mubaracktahir.mia.databinding.FragmentFirstBinding
import com.mubaracktahir.mia.models.Note
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.fragment_first.view.*


/**
 * A simple [Fragment] {HomeFragment} subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    lateinit var adapter: RecyclerviewAdapter
    var arrayList: ArrayList<Note> = ArrayList()
    lateinit var binding: FragmentFirstBinding
    lateinit var drawers: ManageDrawer

    /**
     *  This interface serves as a call back from the parent activity [MainActivity]
     *  to either open or close the DrawerLayout from within the fragment [HomeFragment]
     */
    interface ManageDrawer {
        fun openDrawerLayout()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_first, container, false
        )
        return binding.root
    }

    /**
     * Initializing view and listeners
     * [initializeRecyclerView]  [createNewNotes]
     */

    private fun init() {

        //recyclerView init
        initializeRecyclerView()

        //drawer click
        binding.drawerButton.setOnClickListener {
            drawers.openDrawerLayout()
        }

        //fab to create note
        binding.root.fab.setOnClickListener { view ->
            createNewNotes()
        }

    }

    /**
     *
     * Setting up recyclerView
     *
     */
    private fun initializeRecyclerView() {
        adapter = RecyclerviewAdapter {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        }
        binding.root.recycler_view.setHasFixedSize(true)
        binding.root.recycler_view.layoutManager =
            StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        binding.root.recycler_view.adapter = adapter
    }


    /**
     *
     *Create new Notes this is dummy though it would be changed soon
     */
    private fun createNewNotes() {
        arrayList.add(Note(isTodo = false,description = "Hello, What will you like for lunch?",todoList = arrayListOf(),date = "23:00"))
        arrayList.add(Note(isTodo = true,description = "Hello, What will you like for lunch?",todoList = arrayListOf(),date = "23:00"))
        adapter.notes.clear()
        adapter.notes.addAll(arrayList)
        adapter.notifyDataSetChanged()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    override fun onAttach(context: Context) {
        try {
            drawers = activity as ManageDrawer
        } catch (h: ClassCastException) {

        }
        super.onAttach(context)

    }
}