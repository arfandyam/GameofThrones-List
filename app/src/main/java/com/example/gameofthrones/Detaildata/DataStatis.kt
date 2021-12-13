package com.example.gameofthrones.Detaildata

import com.example.gameofthrones.DataCharacterItem

class DataStatis {

    companion object{
        var family: String = ""
        var firstName: String = ""
        var fullName: String = ""
        var id: Int? = null
        var image: String = ""
        var imageUrl: String = ""
        var lastName: String = ""
        var title: String = ""

        fun fill(character : DataCharacterItem){

            family = character.family
            firstName = character.firstName
            fullName = character.fullName
            id = character.id
            image = character.image
            imageUrl = character.imageUrl
            lastName = character.lastName
            title = character.title
        }
    }
}