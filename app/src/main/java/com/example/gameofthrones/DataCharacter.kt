package com.example.gameofthrones

class DataCharacter : ArrayList<DataCharacterItem>()

data class DataCharacterItem(
    val family: String,
    val firstName: String,
    val fullName: String,
    val id: Int,
    val image: String,
    val imageUrl: String,
    val lastName: String,
    val title: String
)