package com.flowapps.assingmentopenweb.service.repository

import com.flowapps.assingmentopenweb.App
import com.flowapps.assingmentopenweb.R
import com.flowapps.assingmentopenweb.service.models.Person
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.text.SimpleDateFormat

object ProjectRepository {

    val skipHeader = true

    fun loadData() : List<Person> {
        val listData = arrayListOf<Person>()
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        val inputStream: InputStream = App.applicationContext().resources.openRawResource(R.raw.issues)
        val reader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))
        var index = 0

        try {
            while (true) {
                index++
                val line = reader.readLine() ?: break

                if (index == 1 && skipHeader) {
                    continue
                } else {
                    val tokens: List<String> = line.split(",")

                    val person = Person(
                            tokens[0].replace("\"", ""),
                            tokens[1].replace("\"", ""),
                            tokens[2].replace("\"", ""),
                            format.parse(tokens[3].replace("\"", "")))
                    listData.add(person)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return listData
    }
}