package com.mubaracktahir.notie.ui.screens.reminder

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mubaracktahir.notie.R

class FragmentReminder : Fragment() {

    companion object {
        fun newInstance() = FragmentReminder()
    }

    private lateinit var viewModel: FragmentReminderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reminder_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentReminderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}