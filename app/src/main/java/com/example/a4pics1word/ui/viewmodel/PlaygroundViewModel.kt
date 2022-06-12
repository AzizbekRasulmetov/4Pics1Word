package com.example.a4pics1word.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a4pics1word.model.QuestionData
import com.example.a4pics1word.repository.QuestionRepository

class PlaygroundViewModel : ViewModel() {

    private val repository = QuestionRepository()

    val questionLiveData = MutableLiveData<QuestionData>()


    fun getQuestion(index: Int, playground: String) {
        when (playground) {
            "Newbie" -> {
                val question = repository.loadNewbieQuestions()[index]
                questionLiveData.value = question
            }
            "Middle" -> {

            }
            "Expert" -> {

            }
        }
    }

}