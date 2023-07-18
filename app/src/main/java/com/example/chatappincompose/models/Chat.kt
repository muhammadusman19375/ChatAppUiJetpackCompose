package com.example.chatappincompose.models

data class Chat(
    val id: Int,
    val message: String,
    val time: String,
    val isSender: Boolean
)

val chatList = listOf(
    Chat(0,"Hey", "12:17 PM", true),
    Chat(1,"What is your name?", "12:17 PM", false),
    Chat(2,"What is your father name?", "12:17 PM", false),
    Chat(3,"What are you doing", "12:17 PM", true),
    Chat(4,"Yes, I am Usman", "12:17 PM", false),
    Chat(5,"Where are you from?", "12:17 PM", true),
    Chat(6,"I am from Sargodha", "12:17 PM", false),
    Chat(7,"Your qualification", "12:17 PM", true),
    Chat(8,"Are you professional developer", "12:17 PM", false),
    Chat(9,"What is your hobby", "12:17 PM", true),
    Chat(10,"I am College Student", "12:17 PM", false),
    Chat(11,"What is your name?", "12:17 PM", false),
    Chat(12,"What is your father name?", "12:17 PM", false),
    Chat(13,"What are you doing", "12:17 PM", true),
    Chat(14,"Yes, I am Usman", "12:17 PM", false),
    Chat(15,"Where are you from?", "12:17 PM", true),
    Chat(16,"I am from Sargodha", "12:17 PM", false),
    Chat(17,"Your qualification", "12:17 PM", true),
    Chat(18,"Are you professional developer", "12:17 PM", false)
)