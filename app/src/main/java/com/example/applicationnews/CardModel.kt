package com.example.applicationnews

class CardModel {
    var modelName: String? = null
    var modelText: String? = null
    var modelAuthor: String? = null
    var modelUrl: String? = null
    var modelPublishedAt: String? = null
    var modelUrlToImage: String? = null

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

    fun getAuthor(): String {
        return modelAuthor.toString()
    }

    fun setAuthor(author: String) {
        this.modelAuthor = author
    }

    fun getUrl(): String {
        return modelAuthor.toString()
    }

    fun setUrl(url: String) {
        this.modelUrl = url
    }

    fun getmodelPublishedAt(): String {
        return modelPublishedAt.toString()
    }

    fun setPublishedAt(publishedAt: String) {
        this.modelPublishedAt = publishedAt
    }

    fun getmodelUrlToImage(): String {
        return modelUrlToImage.toString()
    }

    fun setUrlToImage(urlToImage: String) {
        this.modelUrlToImage = urlToImage
    }

    fun getImages(): Int {
        return modelImage
    }

    fun setImages(image_drawable: Int) {
        this.modelImage = image_drawable
    }
}