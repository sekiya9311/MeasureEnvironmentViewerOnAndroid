package com.sekiya9311.measureenvironment.feature.environmentgraph

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.github.mikephil.charting.charts.LineChart
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.ServiceContainer
import com.sekiya9311.measureenvironment.databinding.FragmentEnvironmentGraphBinding
import com.sekiya9311.measureenvironment.repository.db.EnvironmentDao

class EnvironmentGraphFragment : Fragment(R.layout.fragment_environment_graph) {

    private val args: EnvironmentGraphFragmentArgs by navArgs()
    private val viewModel: EnvironmentGraphViewModel by viewModels {
        EnvironmentGraphViewModelFactory(
            args.dateString,
            ServiceContainer.resolve(EnvironmentDao::class.java.simpleName)!!
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEnvironmentGraphBinding.bind(view).apply {
            dateText.text = viewModel.dateString
        }

        setupChart(binding.chart)
    }

    private fun setupChart(chart: LineChart) {
    }
}
