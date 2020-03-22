package com.sekiya9311.measureenvironment.feature.environments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.ServiceContainer
import com.sekiya9311.measureenvironment.databinding.FragmentEnvironmentsBinding
import com.sekiya9311.measureenvironment.repository.FirestoreRepository
import com.sekiya9311.measureenvironment.repository.db.EnvironmentDao
import com.sekiya9311.measureenvironment.toDateString
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.GroupieViewHolder

class EnvironmentsFragment : Fragment(R.layout.fragment_environments) {

    private val viewModel: EnvironmentsViewModel by viewModels {
        EnvironmentsViewModelFactory(
            ServiceContainer.resolve(FirestoreRepository::class.java.simpleName)!!,
            ServiceContainer.resolve(EnvironmentDao::class.java.simpleName)!!
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

        viewModel.environmentsADay.observe(viewLifecycleOwner) { environmentsADay ->
            val items = environmentsADay.map {
                EnvironmentsItem(it) {
                    val directions = EnvironmentsFragmentDirections
                        .actionEnvironmentsFragmentToEnvironmentGraphFragment(
                            it.createdAt?.toDateString() ?: ""
                        )
                    findNavController().navigate(directions)
                }
            }

            groupAdapter.update(items)
        }
    }
}
