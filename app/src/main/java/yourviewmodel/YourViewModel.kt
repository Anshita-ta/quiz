package com.example.quiz

import androidx.lifecycle.ViewModel

class YourViewModel(val list: List<QuestionModel>) : ViewModel() {

    private var currentIndex = 0

    fun getCurrentQuestion(): QuestionModel {
        if (currentIndex >= 0 && currentIndex < list.size) {
            return list[currentIndex]
        } else {
            throw IndexOutOfBoundsException("Index $currentIndex is out of bounds.")
        }
    }

    // Add a function to move to the next question
    fun moveToNextQuestion() {
        currentIndex++
    }
}


