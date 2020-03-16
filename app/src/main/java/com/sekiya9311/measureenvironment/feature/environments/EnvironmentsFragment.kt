package com.sekiya9311.measureenvironment.feature.environments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.databinding.FragmentEnvironmentsBinding
import com.sekiya9311.measureenvironment.model.Environment
import com.sekiya9311.measureenvironment.model.EnvironmentADay
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.GroupieViewHolder
import java.util.*

class EnvironmentsFragment : Fragment(R.layout.fragment_environments) {

    private val viewModel: EnvironmentsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEnvironmentsBinding.bind(view)
        setupRecyclerView(binding)
    }

    private fun setupRecyclerView(binding: FragmentEnvironmentsBinding) {
        val groupAdapter = GroupAdapter<GroupieViewHolder<*>>()
        binding.environmentsRecyclerView.adapter = groupAdapter

        val sampleItems = listOf(
            EnvironmentsItem(EnvironmentADay(listOf(Environment(0.0, Date()))))
        )

        groupAdapter.update(sampleItems)
    }
}
