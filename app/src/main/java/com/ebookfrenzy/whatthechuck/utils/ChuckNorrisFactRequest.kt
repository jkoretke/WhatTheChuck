package com.ebookfrenzy.whatthechuck.utils

import com.ebookfrenzy.whatthechuck.ChuckNorrisFact
import com.google.gson.Gson

object ChuckNorrisFactRequest {

    fun getChuckNorrisFact(): ChuckNorrisFact {

        val httpClient = HTTPClient()
        val fullJson = httpClient.getJson()

        val gson = Gson()
        return gson.fromJson(fullJson, ChuckNorrisFact::class.java)
    }
}