package com.flowapps.parseCSV.presentation.view.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.flowapps.parseCSV.R
import com.flowapps.parseCSV.presentation.view.fragment.settings.SettingsFragment
import com.flowapps.parseCSV.presentation.view.fragment.settings.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SettingsFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.fragment_container)
        setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(toolbar_layout, toolbar, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController(R.id.fragment_container))
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }

    override fun onSupportNavigateUp() = findNavController(R.id.fragment_container).navigateUp()

}
