package com.mubaracktahir.notie.ui.screens.trash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mubaracktahir.notie.R

class FragmentTrash : Fragment() {

    companion object {
        fun newInstance() = FragmentTrash()
    }

    private lateinit var viewModel: FragmentTrashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trash_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentTrashViewModel::class.java)
        // TODO: Use the ViewModel
    }

}