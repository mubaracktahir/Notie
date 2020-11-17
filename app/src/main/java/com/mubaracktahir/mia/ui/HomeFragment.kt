package com.mubaracktahir.mia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mubaracktahir.mia.R
import com.mubaracktahir.mia.adapter.RecyclerviewAdapter
import com.mubaracktahir.mia.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.fragment_first.view.*


/**
 * A simple [Fragment] {HomeFragment} subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {
    lateinit var adapter: RecyclerviewAdapter
    var arrayList: ArrayList<String> = ArrayList()
    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_first, container, false)
        return binding.root
    }

    /**
     * Initializing view and listeners
     * [initializeRecyclerView] [initializeNavigationView] [createNewNotes]
     */
    private fun init() {

        //recyclerView init
        initializeRecyclerView()

        //drawerLayout init
        initializeNavigationView()

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
     *  setting up navigation View and DrawerLayout (that thing that is being swiped from the left)
     *
     */
    private fun initializeNavigationView() {
        binding.root.navigation_drawer.setNavigationItemSelectedListener {
            val id = it.itemId
            when (id) {
                R.id.all_notes -> {
                    Toast.makeText(activity, id, Toast.LENGTH_LONG).show()
                }
            }
            return@setNavigationItemSelectedListener true
        }
        binding.root.drawer_layout.setScrimColor(resources.getColor(R.color.colorPrimaryDark))
        binding.root.drawer_layout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                val diffScaleOffset = slideOffset * (1 - 0.7f);
                val xOffSetScale = drawerView.width * slideOffset
                val xOffScaleDiff = binding.root.content_view.width * diffScaleOffset / 2
                val xTranslation = xOffSetScale - xOffScaleDiff
                binding.root.content_view.translationX = xTranslation

            }

            override fun onDrawerClosed(drawerView: View) {
            }

            override fun onDrawerOpened(drawerView: View) {
            }

        })
        binding.root.navigation_drawer.bringToFront()
        binding.root.navigation_drawer.setCheckedItem(R.id.all_notes)
        binding.root.drawer_button.setOnClickListener {
            if (binding.root.drawer_layout.isDrawerVisible(GravityCompat.START))
                binding.root.drawer_layout.closeDrawer(GravityCompat.START)
            else
                binding.root.drawer_layout.openDrawer(GravityCompat.START)
        }
    }

    /**
     *
     *Create new Notes this is dummy though it would be changed soon
     */
    private fun createNewNotes() {

        arrayList.add(0, "Hello, What will you like for lunch?")
        arrayList.add(
            0, "Hello, my name is Mubarack," + " I am an android Developer"
        )
        arrayList.add(
            0, "I'm at work, I will call you when I'm  back. Say me hi to henry. Bye for now."
        )
        arrayList.add(
            0, "\"This is a sign of the signature\""
        )
        arrayList.add(
            0,
            "\"Who should i give my love too, listen most too, never say 'no' too after Allah " +
                    "and rasullulah? \ncount your Mother, \nwho next ? \nyour Mother \nWho next?" +
                    "\nYour mother and then your father\""
        )

        adapter.notes.clear()
        adapter.notes.addAll(arrayList)
        adapter.notifyDataSetChanged()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
}