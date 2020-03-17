package com.sekiya9311.measureenvironment.feature.environments

import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.databinding.ItemEnvironmentsBinding
import com.sekiya9311.measureenvironment.model.EnvironmentADay
import com.sekiya9311.measureenvironment.toDateString
import com.xwray.groupie.databinding.BindableItem

class EnvironmentsItem(
    private val environmentsADay: EnvironmentADay
) : BindableItem<ItemEnvironmentsBinding>(environmentsADay.hashCode().toLong()) {
    override fun getLayout(): Int = R.layout.item_environments

    override fun bind(viewBinding: ItemEnvironmentsBinding, position: Int) {
        viewBinding.dateText.text = environmentsADay.createdAt?.toDateString() ?: ""
        viewBinding.co2AverageText.text = environmentsADay.co2Average.toString()
    }
}