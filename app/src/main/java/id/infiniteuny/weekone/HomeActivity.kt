package id.infiniteuny.weekone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import id.infiniteuny.weekone.data.ApiClient
import id.infiniteuny.weekone.data.model.Todo
import id.infiniteuny.weekone.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private lateinit var binding: ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    val listTodo= mutableListOf<Todo>()
    val rvAdapter=TodoAdapter(listTodo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        val user = User(
            intent.getStringExtra("username")!!,
            intent.getStringExtra("name")!!,
            intent.getStringExtra("email")!!,
            intent.getStringExtra("phone")!!
        )

        binding.userUsername.text = "Usernamenya : ${user.username}"
        binding.userName.text = "Namenya : ${user.name}"
        binding.userEmail.text = "Emailnya : ${user.email}"
        binding.userPhone.text = "Phonenya : ${user.phone}"

        binding.userUsername.setOnClickListener {
            rvAdapter.notifyDataSetChanged()
        }

        binding.rvTodos.apply {
            adapter=rvAdapter
            layoutManager=LinearLayoutManager(this@HomeActivity)
        }

        getData()
    }

    private fun getData(){
        ApiClient.getService().getTodos().enqueue(object : Callback<List<Todo>>{
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                Log.d("onResponse : ",response.body().toString())
                listTodo.clear()
                if(response.body()!=null){
                    listTodo.addAll(response.body()!!)
                }
                //rvAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.e("onFailure : ",t.localizedMessage.toString())
            }

        })
    }
}