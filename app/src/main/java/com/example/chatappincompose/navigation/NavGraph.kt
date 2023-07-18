package com.example.chatappincompose.navigation

sealed class NavGraph(val route: String) {
    object StartScreen: NavGraph("StartScreen")
    object HomeScreen: NavGraph("HomeScreen")
    object ChatScreen: NavGraph("ChatScreen/{personData}") {
        fun sendPersonData(personData: String) = "ChatScreen/$personData"
    }
}
