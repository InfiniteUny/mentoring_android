package id.infiniteuny.weekone.ui

import id.infiniteuny.weekone.model.Todo
import id.infiniteuny.weekone.repository.TodoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoPresenter(val view: TodoContract, val todoRepository: TodoRepository) {

    fun getAllTodo() {
        view.showLoading()
        todoRepository.getAllTodo().enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                view.hideLoading()
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result.isNullOrEmpty()) view.showError("waduh kosong neh datanya")
                    else view.showDataTodo(result)
                }
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                view.hideLoading()
                view.showError("error ${t.message}")
            }

        })
    }
}