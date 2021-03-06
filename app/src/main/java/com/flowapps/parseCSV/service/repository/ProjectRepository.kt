package com.flowapps.parseCSV.service.repository

import android.annotation.SuppressLint
import com.flowapps.parseCSV.App
import com.flowapps.parseCSV.R
import com.flowapps.parseCSV.service.models.Person
import com.flowapps.parseCSV.service.models.selectAllPersona
import com.raizlabs.android.dbflow.kotlinextensions.save
import de.siegmar.fastcsv.reader.CsvReader
import java.io.InputStreamReader
import java.text.SimpleDateFormat

/**
 * Demo repository, uses the FastCSV library for reading and parsing locally included CSV file.
 *
 * @see <a href="https://github.com/osiegmar/FastCSV">CsvReader</a>
 */
object ProjectRepository {

    private const val skipHeader = true

    fun loadData() : List<Person> {

        var persons : List<Person> = retrievePersons()
        if (persons.isEmpty()) {
            persons = parseData()
            persons.forEach({
                it.save()
            })
        }

        return persons
    }

    private fun retrievePersons(): List<Person> {
        return selectAllPersona()
    }

    @SuppressLint("SimpleDateFormat")
    private fun parseData(): List<Person> {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val listData = arrayListOf<Person>()

        val inputStream = App.applicationContext().resources.openRawResource(R.raw.issues)
        val inputReader = InputStreamReader(inputStream)
        val csvReader = CsvReader()
        csvReader.setContainsHeader(skipHeader)

        val csv = csvReader.read(inputReader)
        csv.rows.forEach({
            val person = Person(it.getField("First name"),
                    it.getField("Sur name"),
                    it.getField("Issue count"),
                    format.parse(it.getField("Date of birth")))
            listData.add(person)
        })

        inputReader.close()
        inputStream.close()

        return listData
    }
}