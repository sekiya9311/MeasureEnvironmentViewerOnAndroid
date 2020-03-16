package com.sekiya9311.measureenvironment.feature.environments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.databinding.FragmentEnvironmentsBinding

class EnvironmentsFragment : Fragment(R.layout.fragment_environments) {

    private val viewModel: EnvironmentsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEnvironmentsBinding.bind(view)
    }
}
