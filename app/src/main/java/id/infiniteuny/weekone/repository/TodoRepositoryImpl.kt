package id.infiniteuny.weekone.repository

import id.infiniteuny.weekone.model.Todo
import id.infiniteuny.weekone.services.AppServices
import retrofit2.Call

class TodoRepositoryImpl : TodoRepository {
    override fun getAllTodo(): Call<List<Todo>> {
        return AppServices.create().getAllTodo()
    }
}