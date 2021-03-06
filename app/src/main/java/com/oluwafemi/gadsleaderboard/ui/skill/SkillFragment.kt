package com.oluwafemi.gadsleaderboard.ui.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oluwafemi.gadsleaderboard.R
import com.oluwafemi.gadsleaderboard.adapter.SkillAdapter
import com.oluwafemi.gadsleaderboard.databinding.FragmentSkillBinding

class SkillFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(SkillViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSkillBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_skill, container, false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerSkill.adapter = SkillAdapter()

        return binding.root
    }

}