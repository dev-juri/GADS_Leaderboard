package com.oluwafemi.gadsleaderboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.gadsleaderboard.databinding.SkillLeadersBinding
import com.oluwafemi.gadsleaderboard.models.SkillLeaders

class SkillAdapter : ListAdapter<SkillLeaders, SkillAdapter.SkillViewHolder>(DiffUtilCalBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        return SkillViewHolder(
            SkillLeadersBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val skillLeaders = getItem(position)
        holder.bind(skillLeaders)
    }

    companion object DiffUtilCalBack : DiffUtil.ItemCallback<SkillLeaders>(){
        override fun areItemsTheSame(oldItem: SkillLeaders, newItem: SkillLeaders): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: SkillLeaders, newItem: SkillLeaders): Boolean {
            return oldItem.score == newItem.score
        }

    }

    class SkillViewHolder (private val binding : SkillLeadersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(skillLeaders: SkillLeaders){
            binding.skillData = skillLeaders
            binding.executePendingBindings()
        }
    }


}