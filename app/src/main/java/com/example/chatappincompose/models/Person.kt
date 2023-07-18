package com.example.chatappincompose.models

import androidx.annotation.DrawableRes
import com.example.chatappincompose.R

data class Person(
    val id: Int,
    val name: String,
    @DrawableRes val icon: Int = R.drawable.img1
)

val personList = listOf(
    Person(1, "Usman", R.drawable.img1),
    Person(2, "Irfan", R.drawable.img2),
    Person(3, "Haider", R.drawable.img3),
    Person(4, "Afaq", R.drawable.img1),
    Person(5, "Nasir", R.drawable.img3),
    Person(6, "GM Sb", R.drawable.img2),
    Person(7, "Ahmad", R.drawable.img1),
    Person(8, "Amir", R.drawable.img2),
    Person(9, "Asif", R.drawable.img3),
    Person(10, "Qasim", R.drawable.img2),
    Person(11, "Hasnain", R.drawable.img3),
    Person(12, "Umair", R.drawable.img1),
    Person(13, "Zubair", R.drawable.img2),
    Person(14, "Talib", R.drawable.img1),
    Person(15, "Noor", R.drawable.img3),
    Person(16, "Zeeshan", R.drawable.img1)
)
