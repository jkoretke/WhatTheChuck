package com.ebookfrenzy.whatthechuck.utils

import android.util.Log
import kotlinx.coroutines.GlobalScope
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HTTPClient() {

    val url = URL("https://api.chucknorris.io/jokes/random")
    fun getJson(): String {

        val con = url.openConnection() as HttpsURLConnection
        con.requestMethod = "GET"

        val responsCode = con.responseCode
        if(responsCode != 200){
            Log.d(this.javaClass.simpleName, "Invalid API call. Response code: $responsCode")
        }

        val readIn = BufferedReader(
            InputStreamReader(con.inputStream)
        )
        var inputLine: String?
        val response = StringBuilder()

        while (readIn.readLine().also { inputLine = it } != null) response.append(inputLine)

        readIn.close()

        return response.toString()
    }
}