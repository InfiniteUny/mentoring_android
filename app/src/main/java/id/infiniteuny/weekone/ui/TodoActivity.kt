package id.infiniteuny.weekone.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.infiniteuny.weekone.R
import id.infiniteuny.weekone.databinding.ActivityTodoBinding
import id.infiniteuny.weekone.model.Todo
import id.infiniteuny.weekone.repository.TodoRepositoryImpl

class TodoActivity : AppCompatActivity(), TodoContract {
    private lateinit var presenter: TodoPresenter
    private val adapter by lazy { TodoRecycleViewAdapter(emptyList()) }
    private lateinit var binding: ActivityTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecycleView()
        val todoRepo = TodoRepositoryImpl()
        presenter = TodoPresenter(this, todoRepo)

        presenter.getAllTodo()
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showDataTodo(listTodo: List<Todo>) {
        adapter.refreshTodo(listTodo)
    }

    override fun showError(errorMessage: String) {
        binding.rvTodo.visibility = View.GONE
    }

    private fun setupRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvTodo.layoutManager = layoutManager
        binding.rvTodo.adapter = adapter
    }
}