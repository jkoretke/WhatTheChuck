package com.ebookfrenzy.whatthechuck.utils

import com.ebookfrenzy.whatthechuck.ChuckNorrisFact
import com.google.gson.Gson
import java.net.URL

object ChuckNorrisFactRequest {

    private const val BASE_URL = "https://api.chucknorris.io/jokes/random?category=dev"

    fun getChuckNorrisFactFromAPI(): ChuckNorrisFact {

        val url = URL(BASE_URL)
        val httpClient = HTTPClient(url)
        val fullJson = httpClient.getJson()
        val gson = Gson()
        return gson.fromJson(fullJson, ChuckNorrisFact::class.java)
    }
}