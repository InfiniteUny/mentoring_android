package id.infiniteuny.weekone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.infiniteuny.weekone.databinding.ActivityHomeBinding

private lateinit var binding: ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
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
    }
}