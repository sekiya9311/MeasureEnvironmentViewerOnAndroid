package com.sekiya9311.measureenvironment.feature.environmentgraph

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.databinding.FragmentEnvironmentGraphBinding

class EnvironmentGraphFragment : Fragment(R.layout.fragment_environment_graph) {

    private val args: EnvironmentGraphFragmentArgs by navArgs()
    private val viewModel: EnvironmentGraphViewModel by viewModels {
        EnvironmentGraphViewModelFactory(args.dateString)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEnvironmentGraphBinding.bind(view)
    }
}
