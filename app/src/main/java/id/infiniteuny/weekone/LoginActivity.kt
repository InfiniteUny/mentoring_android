package id.infiniteuny.weekone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.infiniteuny.weekone.databinding.ActivityLoginBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val user = User("admin", "Administrator", "admin@gmail.com", "082310487958")

        binding.btnLogin.setOnClickListener {
            val username = binding.loginUsername.text.toString()
            val password = binding.loginPassword.text.toString()
            doLogin(username, password, user)
        }
    }

    private fun doLogin(username: String, password: String, user: User) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("username", user.username)
        intent.putExtra("name", user.name)
        intent.putExtra("email", user.email)
        intent.putExtra("phone", user.phone)

        if (username == "admin" && password == "admin123"){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
        }
    }
}