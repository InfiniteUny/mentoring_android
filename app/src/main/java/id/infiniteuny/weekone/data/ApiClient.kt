package id.infiniteuny.weekone.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        private fun getClient():Retrofit{
            return Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getService():WebService= getClient().create(WebService::class.java)

    }
}