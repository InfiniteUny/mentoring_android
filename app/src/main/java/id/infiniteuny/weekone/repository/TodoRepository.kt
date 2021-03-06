package id.infiniteuny.weekone.repository

import id.infiniteuny.weekone.model.Todo
import retrofit2.Call

interface TodoRepository {
    fun getAllTodo(): Call<List<Todo>>
}