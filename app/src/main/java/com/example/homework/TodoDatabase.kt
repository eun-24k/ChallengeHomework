package com.example.homework

import android.util.Log
import com.example.homework.todo.TodoData

object TodoDatabase {

    var totalTodoList: ArrayList<TodoData> = arrayListOf(
        TodoData("title 0", "description 0", false),
        TodoData("title 1", "description 1", false),
        TodoData("title 2", "description 2", false)
    )

    fun addToList(info: TodoData) {
        totalTodoList.add(info)
        Log.d("todoList", "$totalTodoList")
    }
}