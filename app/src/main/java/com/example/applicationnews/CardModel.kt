package com.example.applicationnews

class CardModel {
    var modelName: String? = null
    var modelText: String? = null
    private var modelImage: Int = 0

    fun getNames(): String {
        return modelName.toString()
    }

    fun setNames(name: String) {
        this.modelName = name
    }

    fun getTexts(): String {
        return modelText.toString()
    }

    fun setTexts(name: String) {
        this.modelText = name
    }

    fun getImages(): Int {
        return modelImage
    }

    fun setImages(image_drawable: Int) {
        this.modelImage = image_drawable
    }
}