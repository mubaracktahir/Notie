package com.mubaracktahir.notie.ui.screens.Labels

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mubaracktahir.notie.R

class FrangmentLabels : Fragment() {

    companion object {
        fun newInstance() = FrangmentLabels()
    }

    private lateinit var viewModel: FrangmentLabelsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frangment_labels_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FrangmentLabelsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}