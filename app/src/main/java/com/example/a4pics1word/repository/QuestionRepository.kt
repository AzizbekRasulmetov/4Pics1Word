package com.example.a4pics1word.repository

import com.example.a4pics1word.R
import com.example.a4pics1word.model.QuestionData

class QuestionRepository {

    fun loadNewbieQuestions(): List<QuestionData> {
        val arrayList = ArrayList<QuestionData>()

        arrayList.add(
            QuestionData(
                "TULKI",
                "KIALTU",
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image1,
            )
        )
        arrayList.add(
            QuestionData(
                "MAKTAB",
                "BMAKAT",
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image1,
            )
        )
        return arrayList
    }

    fun getQuestion(index: Int) {
        loadNewbieQuestions()[index]
    }



}