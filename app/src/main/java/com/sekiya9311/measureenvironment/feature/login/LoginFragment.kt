package com.sekiya9311.measureenvironment.feature.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sekiya9311.measureenvironment.R
import com.sekiya9311.measureenvironment.ServiceContainer
import com.sekiya9311.measureenvironment.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(
            ServiceContainer.resolve("FirestoreRepository")!!
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = FragmentLoginBinding.bind(view)

        viewModel.isAuthorized.observe(viewLifecycleOwner, Observer { authorized ->
            if (authorized == null) {
                return@Observer
            }

            if (!authorized) {
                activity?.finishAndRemoveTask()
                return@Observer
            }

            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToEnvironmentsFragment()
            )
        })

    }
}
