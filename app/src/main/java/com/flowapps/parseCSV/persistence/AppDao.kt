package com.flowapps.parseCSV.persistence

import androidx.room.*
import com.flowapps.parseCSV.service.models.Person

@Dao
interface AppDao {

    @Query("SELECT * FROM Person")
    fun selectAllPersona(): List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersons(person: List<Person>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Update
    fun updatePersons(person: List<Person>)

    @Update
    fun updatePerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Delete
    fun deletePersons(person: List<Person>)
}