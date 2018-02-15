package com.flowapps.parseCSV.presentation.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.flowapps.parseCSV.R
import com.flowapps.parseCSV.databinding.ActivityMainBinding
import com.flowapps.parseCSV.presentation.view.adapter.PersonAdapter
import com.flowapps.parseCSV.presentation.viewmodel.PersonListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val personAdapter: PersonAdapter = PersonAdapter()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.isLoading = true

        setSupportActionBar(toolbar)

        recyclerview.adapter = personAdapter

        val personListViewModel: PersonListViewModel = ViewModelProviders.of(this).get(PersonListViewModel::class.java)
        observeViewModel(personListViewModel)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings ->
                return true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun observeViewModel(personListViewModel: PersonListViewModel) {
        personListViewModel.getData().observe(this, Observer { persons ->
            personAdapter.setData(persons)
            personAdapter.notifyDataSetChanged()
            mainBinding.isLoading = false

        })
    }
}
