package com.oluwafemi.gadsleaderboard.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.gadsleaderboard.models.SkillLeaders
import com.oluwafemi.gadsleaderboard.models.TimeLeaders

@BindingAdapter("leaderList")
fun bindLeaderRecyclerView(recyclerView: RecyclerView, data : List<TimeLeaders>?) {
    val adapter = recyclerView.adapter as LearningAdapter
    adapter.submitList(data)
}

@BindingAdapter("skillLeaderList")
fun bindSkillLeaderRecyclerView(recyclerView: RecyclerView, data : List<SkillLeaders>?) {
    val adapter = recyclerView.adapter as SkillAdapter
    adapter.submitList(data)
}