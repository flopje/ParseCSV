package com.flowapps.assingmentopenweb.service.repository

import com.flowapps.assingmentopenweb.service.models.Person

object ProjectRepository {

    fun loadData() : List<Person> {
        val listData = arrayListOf<Person>()
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))
        listData.add(Person("test", "surname", "1", "jdfghdjkghksjdf"))

        return listData
    }
}