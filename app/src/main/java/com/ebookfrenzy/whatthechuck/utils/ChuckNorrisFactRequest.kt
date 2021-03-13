package com.ebookfrenzy.whatthechuck.utils

import com.ebookfrenzy.whatthechuck.ChuckNorrisFact
import com.google.gson.Gson
import java.net.URL

object ChuckNorrisFactRequest {

    private val chuckNorrisFactCategories = listOf(
        "animal",
        "career",
        "celebrity",
        "dev",
        "fashion",
        "food",
        "history",
        "money",
        "movie",
        "music",
        "political",
        "religion",
        "science",
        "sport",
        "travel")

    private const val baseURL = "https://api.chucknorris.io/jokes/random?category="



    fun getChuckNorrisFactFromAPI(): ChuckNorrisFact {

        val url = URL((baseURL + chuckNorrisFactCategories.random()))
        val httpClient = HTTPClient(url)
        val fullJson = httpClient.getJson()

        val gson = Gson()
        return gson.fromJson(fullJson, ChuckNorrisFact::class.java)
    }
}