package com.flowapps.parseCSV.service.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Person(var firstName: String? = null,
             var lastName: String? = null,
             var issueCount: String? = null,
             var dateOfBirth: Date? = null) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun equals(other: Any?): Boolean {
        return try {
            val person = other as Person
            firstName.equals(person.firstName) &&
                    lastName.equals(person.lastName) &&
                    dateOfBirth == person.dateOfBirth
        } catch (e: Exception) {
            false
        }
    }

    override fun hashCode(): Int {
        var result = firstName?.hashCode() ?: 0
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + (issueCount?.hashCode() ?: 0)
        result = 31 * result + (dateOfBirth?.hashCode() ?: 0)
        result = 31 * result + id
        return result
    }
}