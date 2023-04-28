package uz.ravshanbaxranov.a4pics1word.ui.viewmodel

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.ravshanbaxranov.a4pics1word.model.QuestionData
import uz.ravshanbaxranov.a4pics1word.repository.QuestionRepository
import uz.ravshanbaxranov.a4pics1word.repository.SharedPref

class PlaygroundViewModel : ViewModel() {

    private val repository = QuestionRepository
    private val pref = SharedPref.getInstance()

    val questionLiveData = MutableLiveData<QuestionData>()
    val counterLiveData = MutableLiveData<Int>()
    val backLiveData = MutableLiveData<Unit>()
    val correctAnswerLiveData = MutableLiveData<Unit>()
    val inCorrectAnswerLiveData = MutableLiveData<Unit>()
    val finishLiveData = MutableLiveData<Unit>()
    val variantClickLiveData = MutableLiveData<Button>()
    val listSizeLiveData = MutableLiveData<Int>()
    val answerClickLiveData = MutableLiveData<Button>()
    val prefLiveData = MutableLiveData<Int>()
    private val _showLetterChannel = Channel<QuestionData>()
    val showLetterFlow: Flow<QuestionData> = _showLetterChannel.receiveAsFlow()

    fun back() {
        backLiveData.value = Unit
    }


    fun getQuestion(playground: String) {

        when (playground) {
            "Beginner" -> {
                listSizeLiveData.value = repository.loadNewbieQuestions().size
                val index = pref.beginner
                prefLiveData.value = pref.beginner
                val question = repository.loadNewbieQuestions()[index]
                questionLiveData.postValue(question)
                counterLiveData.postValue(index)
            }
            "Medium" -> {
                listSizeLiveData.value = repository.loadMediumQuestions().size
                val index = pref.medium
                prefLiveData.value = pref.medium
                val question = repository.loadMediumQuestions()[index]
                questionLiveData.value = question
                counterLiveData.postValue(index)

            }
            "Expert" -> {
                listSizeLiveData.value = repository.loadExpertQuestions().size
                val index = pref.expert
                prefLiveData.value = pref.expert
                val question = repository.loadExpertQuestions()[index]
                questionLiveData.postValue(question)
                counterLiveData.postValue(index)


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

    fun showFirstLetter( qType: String) {
        viewModelScope.launch {
            when (qType) {
                "Beginner" -> {
                    _showLetterChannel.send(repository.loadNewbieQuestions().elementAt(pref.beginner))
                }
                "Medium" -> {
                    _showLetterChannel.send(repository.loadMediumQuestions().elementAt(pref.medium))
                }
                "Expert" -> {
                    _showLetterChannel.send(repository.loadExpertQuestions().elementAt(pref.expert))
                }
            }

        }
    }

}