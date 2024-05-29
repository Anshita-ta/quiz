package com.example.quiz;
import android.content.Intent
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quiz.databinding.ActivityQuiz2Binding;
import com.example.quiz.YourViewModel;
import android.os.Build.VERSION_CODES.N;
import android.widget.TextView;
import android.widget.Toast
import androidx.lifecycle.ViewModel;
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject


class QuizActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityQuiz2Binding
    private lateinit var list: ArrayList<QuestionModel>
    private lateinit var viewModel: YourViewModel // Declare here
    private var count:Int=0
    private var score =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList<QuestionModel>()
        Firebase.firestore.collection("quiz")
            .get().addOnSuccessListener {
                doct->
                list.clear()
                for(i in doct.documents){

                    var questionModel=i.toObject(QuestionModel::class.java)
                    list.add(questionModel!!)
                }
                binding.question.setText(list.get(0).question)
                binding.option1.setText(list.get(0).option1)
                binding.option2.setText(list.get(0).option2)
                binding.option3.setText(list.get(0).option3)
                binding.option4.setText(list.get(0).option4)
            }

        binding.option1.setOnClickListener{
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener{
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener{
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener{
            nextData(binding.option4.text.toString())
        }
    }
    public fun setScore(num: Int) {
        this.score = num;
    }
    private fun nextData(i:String){
        if(count<list.size){
            if(list.get(count).ans.equals(i)){
                score++
            }
        }

        count++
        if(count>=list.size){
            val intent= Intent(this, ScoreActivity2::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
            finish()
        }
        else{
            binding.question.setText(list.get(count).question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }


    }
}