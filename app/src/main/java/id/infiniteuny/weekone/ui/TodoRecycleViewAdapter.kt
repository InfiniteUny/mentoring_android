package id.infiniteuny.weekone.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.infiniteuny.weekone.databinding.ItemTodoBinding
import id.infiniteuny.weekone.model.Todo

class TodoRecycleViewAdapter(private var listTodo: List<Todo>) :
    RecyclerView.Adapter<TodoRecycleViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listTodo[position])
    }

    override fun getItemCount(): Int = listTodo.size

    class ViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.tvTitle.text = todo.title
            binding.tvIsCompleted.text = todo.completed.toString()
        }

    }

    fun refreshTodo(todo: List<Todo>) {
        this.listTodo = todo
        notifyDataSetChanged()
    }
}