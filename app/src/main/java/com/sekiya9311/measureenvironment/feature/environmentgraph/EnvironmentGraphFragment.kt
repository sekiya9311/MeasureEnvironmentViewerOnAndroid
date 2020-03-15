package com.sekiya9311.measureenvironment.feature.environmentgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.databinding.EnvironmentGraphFragmentBinding

class EnvironmentGraphFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(EnvironmentGraphViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<EnvironmentGraphFragmentBinding>(
            inflater,
            R.layout.environment_graph_fragment,
            container,
            false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
