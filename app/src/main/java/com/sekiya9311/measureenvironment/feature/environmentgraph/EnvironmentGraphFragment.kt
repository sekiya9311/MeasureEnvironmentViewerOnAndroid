package com.sekiya9311.measureenvironment.feature.environmentgraph

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sekiya9311.measureenvironment.databinding.FragmentEnvironmentGraphBinding

class EnvironmentGraphFragment : Fragment() {

    private val viewModel: EnvironmentGraphViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEnvironmentGraphBinding.bind(view)
    }
}
