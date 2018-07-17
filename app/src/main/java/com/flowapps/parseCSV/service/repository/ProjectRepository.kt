package com.flowapps.parseCSV.service.repository

import android.annotation.SuppressLint
import com.flowapps.parseCSV.App
import com.flowapps.parseCSV.R
import com.flowapps.parseCSV.persistence.AppDao
import com.flowapps.parseCSV.persistence.AppDao_Impl
import com.flowapps.parseCSV.service.models.Person
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

        var persons : List<Person> = App.db.appDao().selectAllPersona() ?: listOf()
        if (persons.isEmpty()) {
            App.db.appDao().insertPersons(parseData())
            persons = App.db.appDao().selectAllPersona()
        }

        return persons
    }

    @SuppressLint("SimpleDateFormat")
    private fun parseData(): List<Person> {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val listData = arrayListOf<Person>()

        val inputStream = App.applicationContext().resources.openRawResource(R.raw.issues)
        val inputReader = InputStreamReader(inputStream)
        val csvReader = CsvReader()
        csvReader.setContainsHeader(skipHeader)
        csvReader.setFieldSeparator(',')

        val csv = csvReader.read(inputReader)
        csv.rows.forEach {
            val person = Person(it.getField("First name"),
                    it.getField("Sur name"),
                    it.getField("Issue count"),
                    format.parse(it.getField("Date of birth")))
            listData.add(person)
        }

        inputReader.close()
        inputStream.close()

        return listData
    }
}