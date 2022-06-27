package com.example.a4pics1word.ui.viewmodel

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4pics1word.model.QuestionData
import com.example.a4pics1word.repository.QuestionRepository
import com.example.a4pics1word.repository.SharedPref
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Level

class PlaygroundViewModel : ViewModel() {

    private val repository = QuestionRepository()
    private val pref = SharedPref.getInstance()

    val questionLiveData = MutableLiveData<QuestionData>()
    val backLiveData = MutableLiveData<Unit>()
    val correctAnswerLiveData = MutableLiveData<Unit>()
    val inCorrectAnswerLiveData = MutableLiveData<Unit>()
    val finishLiveData = MutableLiveData<Unit>()
    val variantClickLiveData = MutableLiveData<Button>()
    val listSizeLiveData = MutableLiveData<Int>()
    val answerClickLiveData = MutableLiveData<Button>()
    val prefLiveData = MutableLiveData<Int>()

    fun back() {
        backLiveData.value = Unit
    }


    fun getQuestion(playground: String) {


        when (playground) {
            "Beginner" -> {
                listSizeLiveData.value = repository.loadNewbieQuestions().size
                var indx = pref.beginner
                prefLiveData.value = pref.beginner
                val question = repository.loadNewbieQuestions()[indx]
                questionLiveData.postValue(question)
            }
            "Medium" -> {
                listSizeLiveData.value = repository.loadMediumQuestions().size
                var indx = pref.medium
                prefLiveData.value = pref.medium
                val question = repository.loadMediumQuestions()[indx]
                questionLiveData.value = question
            }
            "Expert" -> {
                listSizeLiveData.value = repository.loadExpertQuestions().size
                var indx = pref.expert
                prefLiveData.value = pref.expert
                val question = repository.loadExpertQuestions()[indx]
                questionLiveData.postValue(question)

            }
        }

    }

    fun variantClick(it: Button) {
        variantClickLiveData.value = it
    }

    fun answerClick(it: Button) {
        answerClickLiveData.value = it
    }

    fun correctAnswer(playground: String) {

        when (playground) {
            "Beginner" -> {
                pref.beginner = pref.beginner + 1
                prefLiveData.value = pref.beginner
            }
            "Medium" -> {
                pref.medium = pref.medium + 1
                prefLiveData.value = pref.medium

            }
            "Expert" -> {
                pref.expert = pref.expert + 1
                prefLiveData.value = pref.expert

            }
        }


        correctAnswerLiveData.value = Unit
    }

    fun finishLevel(level: String) {
        finishLiveData.value = Unit
        when (level) {
            "Beginner" -> {
                pref.level2 = true
                pref.beginner = 0
            }
            "Medium" -> {
                pref.level3 = true
                pref.medium = 0
            }
            "Expert" -> {
                pref.expert = 0
            }
        }
    }

    fun inCorrect() {
        inCorrectAnswerLiveData.value = Unit
    }

}