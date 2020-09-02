package com.oluwafemi.gadsleaderboard.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.gadsleaderboard.models.TimeLeaders

@BindingAdapter("leaderList")
fun bindLeaderRecyclerView(recyclerView: RecyclerView, data : List<TimeLeaders>?) {
    val adapter = recyclerView.adapter as LearningAdapter
    adapter.submitList(data)
}