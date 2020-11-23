package id.ajiguna.vmlvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ajiguna.vmlvapp.adapter.TodoAdapter
import id.ajiguna.vmlvapp.model.TodoViewModel

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val todoVM = TodoViewModel()
        val adapter = TodoAdapter(todoVM.getTodos())
        val rvTodo = findViewById<RecyclerView>(R.id.rv_todo)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)
    }
}