package com.example.a4pics1word.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class QuestionData(
    val answer: String,
    val variants: String,
    val image1: Int,
    val image2: Int,
    val image3: Int,
    val image4: Int,
)