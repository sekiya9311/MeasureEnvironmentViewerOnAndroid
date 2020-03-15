package com.sekiya9311.measureenvironment.feature.environments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.databinding.FragmentEnvironmentsBinding

class EnvironmentsFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(EnvironmentsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentEnvironmentsBinding>(
            inflater,
            R.layout.fragment_environments,
            container,
            false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
