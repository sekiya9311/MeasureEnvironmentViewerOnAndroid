package com.sekiya9311.measureenvironment.feature.environments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.databinding.FragmentEnvironmentsBinding
import com.sekiya9311.measureenvironment.model.EnvironmentADay
import com.sekiya9311.measureenvironment.repository.FirestoreRepository
import com.sekiya9311.measureenvironment.repository.db.AppDatabase
import com.sekiya9311.measureenvironment.toDateString
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.GroupieViewHolder

class EnvironmentsFragment : Fragment(R.layout.fragment_environments) {

    private val firestore by lazy { FirestoreRepository() }
    private val environmentDao by lazy {
        AppDatabase
            .getInstance(requireNotNull(activity).application)
            .environmentDao
    }
    private val viewModel: EnvironmentsViewModel by viewModels {
        EnvironmentsViewModelFactory(
            firestore,
            environmentDao
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEnvironmentsBinding.bind(view)
        setupRecyclerView(binding)
    }

    private fun setupRecyclerView(binding: FragmentEnvironmentsBinding) {
        val groupAdapter = GroupAdapter<GroupieViewHolder<*>>()
        binding.environmentsRecyclerView.adapter = groupAdapter

        viewModel.environments.observe(viewLifecycleOwner) { environments ->
            val items = environments.groupBy {
                it.createdAt.toDateString()
            }.map {
                EnvironmentsItem(EnvironmentADay(it.value)) {
                    val directions = EnvironmentsFragmentDirections
                        .actionEnvironmentsFragmentToEnvironmentGraphFragment(
                            it.key
                        )
                    findNavController().navigate(directions)
                }
            }

            groupAdapter.update(items)
        }
    }
}
