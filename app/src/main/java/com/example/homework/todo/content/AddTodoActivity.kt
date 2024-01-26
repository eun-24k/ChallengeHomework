package com.example.homework.todo.content

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework.databinding.ActivityAddToDoBinding
import com.example.homework.todo.TodoData

class AddTodoActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_TODO_MODEL = "extra_todo_model"
        fun newIntent(
            context: Context
        ) = Intent(context, AddTodoActivity::class.java)
    }

    private val binding: ActivityAddToDoBinding by lazy {
        ActivityAddToDoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        tbActivityToDo.setNavigationOnClickListener {
            finish()
        }

        btnAddTodo.setOnClickListener {
            val intent = Intent().apply {
                val title = etAddTitle.text.toString()
                val description = etAddDescription.text.toString()
                val switch = false
                putExtra(
                    EXTRA_TODO_MODEL,
                    TodoData(
                        title = title,
                        description = description,
                        switch = switch
                    )
                )
            }

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


}
