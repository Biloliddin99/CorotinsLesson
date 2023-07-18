package com.example.corotinslesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)
        val userList = urlToString(URL("http://cbu.uz/uzc/arkhiv-kursov-valyut/json/"))
       tv.text = userList
    }

    private fun urlToString(url: URL): String {

        val stringBuilder = StringBuilder()

//        try {

            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.connect()
            val inputStream = httpURLConnection.inputStream
            val bufferReader = inputStream.bufferedReader()
            val list = bufferReader.readLines()

            for (s in list) {
                stringBuilder.append(s)
            }

            return stringBuilder.toString()

//        }
//    catch (e: Exception) {
//            println("Internetga ulanishni tekshiring...")
//            return ""
//        }
    }

}