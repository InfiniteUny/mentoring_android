package id.infiniteuny.weekone.data

import id.infiniteuny.weekone.data.model.Todo
import retrofit2.Call
import retrofit2.http.GET

interface WebService {
    @GET("todos")
    fun getTodos(): Call<List<Todo>>

}