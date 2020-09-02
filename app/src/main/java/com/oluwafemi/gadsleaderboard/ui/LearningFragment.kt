package com.oluwafemi.gadsleaderboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.oluwafemi.gadsleaderboard.R
import com.oluwafemi.gadsleaderboard.adapter.LearningAdapter
import com.oluwafemi.gadsleaderboard.databinding.FragmentLearningBinding
import com.oluwafemi.gadsleaderboard.viewModels.LearningViewModel

class LearningFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(LearningViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {val binding : FragmentLearningBinding = DataBindingUtil.inflate(
        inflater, R.layout.fragment_learning, container, false
    )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recyclerLearning.adapter = LearningAdapter()

        return binding.root
    }

}