package com.example.homework.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.RvTodoListBinding

class TodoListAdapter : ListAdapter<TodoData, TodoListAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private var binding: RvTodoListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TodoData) {
            binding.apply {
                tvTodoTitle.text = item.title
                tvTodoDescription.text = item.description
                swTodo.isChecked = item.switch
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RvTodoListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<TodoData>() {
            override fun areItemsTheSame(oldItem: TodoData, newItem: TodoData): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: TodoData, newItem: TodoData): Boolean =
                oldItem == newItem

        }
    }

}