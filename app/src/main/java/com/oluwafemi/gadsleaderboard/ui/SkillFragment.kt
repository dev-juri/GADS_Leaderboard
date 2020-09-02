package com.oluwafemi.gadsleaderboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.oluwafemi.gadsleaderboard.R
import com.oluwafemi.gadsleaderboard.databinding.FragmentLeaderBoardBinding
import com.oluwafemi.gadsleaderboard.viewModels.LeaderBoardViewModel

class SkillFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(LeaderBoardViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentLeaderBoardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_skill, container, false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


        return binding.root
    }

}