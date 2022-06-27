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
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10,
                R.drawable.image11,

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

        arrayList.add(
            QuestionData(
                "HOT",
                "ANTODH",
                R.drawable.termometr,
                R.drawable.sun,
                R.drawable.pepper,
                R.drawable.boiled_water,
            )
        )
        return arrayList
    }

    fun loadMediumQuestions(): List<QuestionData> {
        val arrayList = ArrayList<QuestionData>()

        arrayList.add(
            QuestionData(
                "TULKI",
                "KIALTU",
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10,
                R.drawable.image11,

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

        arrayList.add(
            QuestionData(
                "HOT",
                "ANTODH",
                R.drawable.termometr,
                R.drawable.sun,
                R.drawable.pepper,
                R.drawable.boiled_water,
            )
        )
        return arrayList
    }

    fun loadExpertQuestions(): List<QuestionData> {
        val arrayList = ArrayList<QuestionData>()

        arrayList.add(
            QuestionData(
                "TULKI",
                "KIALTU",
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10,
                R.drawable.image11,

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

        arrayList.add(
            QuestionData(
                "HOT",
                "ANTODH",
                R.drawable.termometr,
                R.drawable.sun,
                R.drawable.pepper,
                R.drawable.boiled_water,
            )
        )
        return arrayList
    }

    fun getQuestion(index: Int) {
        loadNewbieQuestions()[index]
    }


}