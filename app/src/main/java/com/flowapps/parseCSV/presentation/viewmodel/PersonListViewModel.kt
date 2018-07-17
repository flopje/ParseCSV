package com.flowapps.parseCSV.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.flowapps.parseCSV.service.models.Person
import com.flowapps.parseCSV.service.repository.ProjectRepository
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

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
            val result = withContext(DefaultDispatcher) {
                delay(2000L)
                ProjectRepository.loadData()
            }
            personListObservable?.value = result
        }
        return personListObservable!!
    }
}