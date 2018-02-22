package com.flowapps.parseCSV.service.models

import com.flowapps.parseCSV.service.database.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.list
import com.raizlabs.android.dbflow.kotlinextensions.select
import java.util.*

@Table(database = AppDatabase::class)
class Person(@Column var firstName: String? = null,
             @Column var lastName: String? = null,
             @Column var issueCount: String? = null,
             @Column var dateOfBirth: Date? = null) {

    @PrimaryKey(autoincrement = true)
    var id: Int = 0
}

fun selectAllPersona() : List<Person> {
    return (select from Person::class).list
}