package com.example.a4pics1word.model

import androidx.annotation.DrawableRes

data class QuestionData(
    val answer: String,
    val variants: String,
    @DrawableRes
    val image1: Int,
    @DrawableRes
    val image2: Int,
    @DrawableRes
    val image3: Int,
    @DrawableRes
    val image4: Int,
)