package id.ajiguna.vmlvapp.model

import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private val listOfTodos = mutableListOf<TodoModel>()
    init {
        listOfTodos.add(TodoModel("PR Mat", "mengerjakan kalkulus"))
        listOfTodos.add(TodoModel("Belajar Android", "pengenalan fragment dan viewmodel"))
    }
    fun getTodos() = listOfTodos
}