package com.example.homework.todo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework.todo.TodoData

class TodoListViewModel: ViewModel() {

    private var _uiState: MutableLiveData<TodoListUiState> = MutableLiveData(TodoListUiState.init())
    val uiState: LiveData<TodoListUiState> get() = _uiState

    fun addTodoItem(todoModel: TodoData?) {
        // LiveData로 데이터를 전송하는 작업
        if (todoModel == null) {
            return
        }

        _uiState.value = uiState.value?.copy(
            list = uiState.value?.list.orEmpty().toMutableList().apply {
                add(todoModel)
            }
        )
    }
}