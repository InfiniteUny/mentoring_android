package id.infiniteuny.weekone.services

import id.infiniteuny.weekone.model.Todo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AppServices {
    @GET("todos")
    fun getAllTodo(): Call<List<Todo>>

    companion object Factory {
        fun create(): AppServices {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .build()

            return retrofit.create(AppServices::class.java)
        }
    }
}