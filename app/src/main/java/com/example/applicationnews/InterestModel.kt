package com.example.applicationnews

class InterestModel {

    var modelText: String? = null

    fun getTexts(): String {
        return modelText.toString()
    }

    fun setTexts(name: String) {
        this.modelText = name
    }

}