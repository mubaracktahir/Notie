package com.mubaracktahir.notie.ui.screens.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mubaracktahir.notie.R
import com.mubaracktahir.notie.adapter.RecyclerviewAdapter
import com.mubaracktahir.notie.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.content_main.view.*


/**
 * A simple [Fragment] {HomeFragment} subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    lateinit var adapter: RecyclerviewAdapter
    lateinit var binding: FragmentFirstBinding
    lateinit var drawers: ManageDrawer
    lateinit var viewModel: HomeFragmentViewModel

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
        refreshList()

        //drawer click
        binding.drawerButton.setOnClickListener {
            drawers.openDrawerLayout()
        }

        viewModel.noteChanged.observe(this.viewLifecycleOwner, Observer {
            if (it)
                refreshList()
        })
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

    private fun refreshList() {
        adapter.notes.clear()
        adapter.notes.addAll(viewModel.arrayList)
        adapter.notifyDataSetChanged()
    }

    override fun onAttach(context: Context) {
        try {
            drawers = activity as ManageDrawer
        } catch (h: ClassCastException) {

        }
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        binding.viewModel = viewModel
        init()
    }
}