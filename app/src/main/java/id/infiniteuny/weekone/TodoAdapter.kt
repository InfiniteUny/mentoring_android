package id.infiniteuny.weekone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.infiniteuny.weekone.data.model.Todo
import id.infiniteuny.weekone.databinding.ItemTodoBinding

class TodoAdapter(private val data:List<Todo>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding=ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int = data.size

    class TodoViewHolder(val binding: ItemTodoBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(item:Todo){
            binding.tvTitle.text=item.title
            binding.tvCompleted.text=item.completed.toString()
        }
    }
}