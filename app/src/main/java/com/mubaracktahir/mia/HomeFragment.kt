package com.mubaracktahir.mia

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
import com.mubaracktahir.mia.adapter.RecyclerviewAdapter
import com.mubaracktahir.mia.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.fragment_first.view.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {
    lateinit var adapter: RecyclerviewAdapter
    lateinit var arrayList: ArrayList<String>
    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return binding.root
    }

    private fun init() {
        initializeRecyclerView()
        initializeNavigationView()
        createNewNotes()
    }

    private fun initializeRecyclerView() {
        adapter = RecyclerviewAdapter {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        }
        binding.root.recycler_view.setHasFixedSize(true)
        binding.root.recycler_view.layoutManager =
            StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        binding.root.recycler_view.adapter = adapter
    }

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

    private fun createNewNotes() {
        arrayList = ArrayList()

        binding.root.fab.setOnClickListener { view ->
            arrayList.add(0, "Hello, my name is Mubarack Tahirdfvfdvdfvdfvdfvdfvdfvd")
            arrayList.add(
                0, "Hello, my name is Mubarack Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd"
            )
            arrayList.add(
                0, "Hello, my name is Mubarack Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd" +
                        "Tahirdfvfdvdfvdfvdfvdfvdfvd"
            )

            adapter.notes.clear()
            adapter.notes.addAll(arrayList)
            adapter.notifyDataSetChanged()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
}