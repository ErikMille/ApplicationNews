package com.example.applicationnews

class InterestModel {

    var modelText: String? = null
    private var modelImage: Int = 0

    fun getTexts(): String {
        return modelText.toString()
    }

    fun setTexts(name: String) {
        this.modelText = name
    }

}