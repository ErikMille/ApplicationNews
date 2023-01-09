package com.example.applicationnews

class CardModel {
    var modelName: String? = null
    var modelText: String? = null
    var modelDescription: String? = null
    var modelAuthor: String? = null
    var modelPublishedAt: String? = null
    var modelUrl: String? = null
    var modelUrlToImage: String? = null

    private var modelImage: Int = 0

    fun getNames(): String {
        return modelName.toString()
    }

    fun setNames(name: String) {
        this.modelName = name
    }

    fun getDescription(): String {
        return modelDescription.toString()
    }

    fun setDescription(description: String) {
        this.modelDescription = description
    }

    fun getTexts(): String {
        return modelText.toString()
    }

    fun setTexts(text: String) {
        this.modelText = text
    }

    fun getAuthor(): String {
        return modelAuthor.toString()
    }

    fun setAuthor(author: String) {
        this.modelAuthor = author
    }

    fun getUrl(): String {
        return modelUrl.toString()
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

    fun getUrlToImage(): String {
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