package com.flowapps.assingmentopenweb.presentation.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.flowapps.assingmentopenweb.service.models.Person
import com.flowapps.assingmentopenweb.service.repository.ProjectRepository
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class PersonListViewModel(application: Application) : AndroidViewModel(application) {

    private var personListObservable: MutableLiveData<List<Person>>? = null
    private var job: Job? = null

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun getData(): MutableLiveData<List<Person>> {
        if (personListObservable == null) {
            personListObservable = MutableLiveData()
        }

        job = launch(UI) {
            val result = async {
                delay(2000L)
                ProjectRepository.loadData()
            }.await()
            personListObservable?.value = result
        }
        return personListObservable!!
    }
}