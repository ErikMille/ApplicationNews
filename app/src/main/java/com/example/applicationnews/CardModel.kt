package com.example.applicationnews

class CardModel {
    var modelName: String? = null
    var modelText: String? = null
    private var modelImage: Int = 0

    /*
     * Return the team name
     */
    fun getNames(): String {
        return modelName.toString()
    }

    /*
     * Set a team name
     */
    fun setNames(name: String) {
        this.modelName = name
    }

    fun getTexts(): String {
        return modelText.toString()
    }

    fun setTexts(name: String) {
        this.modelText = name
    }
    /* Return a team logo
     */
    fun getImages(): Int {
        return modelImage
    }

    /* Set a team logo
     */
    fun setImages(image_drawable: Int) {
        this.modelImage = image_drawable
    }
}