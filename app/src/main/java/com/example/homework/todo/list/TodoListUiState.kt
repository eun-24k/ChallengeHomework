package com.example.homework.todo.list

import com.example.homework.todo.TodoData

data class TodoListUiState (
    val list:List<TodoData>
) {
    companion object {
        fun init() = TodoListUiState(
            list = emptyList()
        )
    }
}