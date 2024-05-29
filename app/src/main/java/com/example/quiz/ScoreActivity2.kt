package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz.databinding.ActivityScore2Binding

class ScoreActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityScore2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScore2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the text for the TextView using data binding
        binding.score.setText("Congrats!! your Score is ${intent.getIntExtra("SCORE",0)}")
    }
}
