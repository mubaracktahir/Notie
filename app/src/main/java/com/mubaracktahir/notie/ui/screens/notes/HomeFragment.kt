package com.mubaracktahir.notie.ui.screens.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mubaracktahir.notie.R
import com.mubaracktahir.notie.adapter.RecyclerviewAdapter
import com.mubaracktahir.notie.databinding.FragmentFirstBinding
import com.mubaracktahir.notie.db.Entity.DataBaseEntitymapper
import com.mubaracktahir.notie.models.Note
import com.mubaracktahir.notie.repo.MainRepo
import com.mubaracktahir.notie.ui.screens.MainFragmentViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_main.view.*
import javax.inject.Inject


/**
 * A simple [Fragment] {HomeFragment} subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var adapter: RecyclerviewAdapter
    lateinit var binding: FragmentFirstBinding
    lateinit var drawers: ManageDrawer
    val viewModel: HomeFragmentViewModel by viewModels()

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
        viewModel.mappper.observe(this.viewLifecycleOwner, Observer {
            listOfNote.clear()
            for (i in it)
                listOfNote.add(mapp.fromEntityToDomainModel(i))
        })
    }

    val mapp = DataBaseEntitymapper()

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

    var listOfNote = arrayListOf<Note>()
    private fun refreshList() {

        adapter.notes.clear()
        adapter.notes.addAll(listOfNote)
        adapter.notifyDataSetChanged()
    }

    override fun onAttach(context: Context) {
        try {
            drawers = activity as ManageDrawer
        } catch (h: ClassCastException) {

        }
        super.onAttach(context)
    }

    @Inject
    lateinit var mainRepo: MainRepo

    lateinit var homeFragmentViewModelFactory: MainFragmentViewModelFactory
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val context = requireNotNull(this.activity).application

        /*homeFragmentViewModelFactory =
            MainFragmentViewModelFactory(context = context, mainRepo = mainRepo)*/
       /* viewModel = ViewModelProvider(
            this,
            homeFragmentViewModelFactory
        ).get(HomeFragmentViewModel::class.java)*/
        binding.viewModel = viewModel
        init()
    }
}