package com.example.homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.RvTodoListBinding

class TodoListAdapter():RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var holdList: Holder

    inner class Holder(binding: RvTodoListBinding): RecyclerView.ViewHolder(binding.root) {
        val switch = binding.swTodo3
        val title = binding.tvTodoTitle3
        val description = binding.tvTodoDescription3
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Holder(RvTodoListBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }
        holdList = holder as Holder
        with(holdList) {
            title.text = TodoDatabase.totalTodoList[position].title
            description.text = TodoDatabase.totalTodoList[position].description
            when(TodoDatabase.totalTodoList[position].switch) {
                true -> switch.isChecked= true
                false -> switch.isChecked = false
            }
        }
    }

}