package com.oluwafemi.gadsleaderboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.gadsleaderboard.databinding.LearningLeadersBinding
import com.oluwafemi.gadsleaderboard.models.TimeLeaders

class LearningAdapter :
    androidx.recyclerview.widget.ListAdapter<TimeLeaders, LearningAdapter.LearningViewHolder>(
        DiffCallBack
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningViewHolder {
        return LearningViewHolder(
            LearningLeadersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LearningViewHolder, position: Int) {
        val leadingLeaders = getItem(position)
        holder.bind(leadingLeaders)
    }

    class LearningViewHolder(private var binding: LearningLeadersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(leaders: TimeLeaders) {
            binding.learningData = leaders
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<TimeLeaders>() {
        override fun areItemsTheSame(oldItem: TimeLeaders, newItem: TimeLeaders): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: TimeLeaders, newItem: TimeLeaders): Boolean {
            return oldItem.hours == newItem.hours
        }
    }
}