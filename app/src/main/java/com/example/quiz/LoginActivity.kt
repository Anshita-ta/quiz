package com.example.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater())
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.button.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(
                binding.Email.editText?.text.toString(),
                binding.Password.editText?.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(this,"User Created!!!",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"User not Created!!!",Toast.LENGTH_LONG).show()
                    }
            }



        }
    }

    private fun LayoutInflater(): LayoutInflater {
        TODO("Not yet implemented")
    }


}




