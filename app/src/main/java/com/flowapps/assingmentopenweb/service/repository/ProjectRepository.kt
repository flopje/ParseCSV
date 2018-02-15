package com.flowapps.assingmentopenweb.service.repository

import com.flowapps.assingmentopenweb.App
import com.flowapps.assingmentopenweb.R
import com.flowapps.assingmentopenweb.service.models.Person
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

        return listData
    }
}