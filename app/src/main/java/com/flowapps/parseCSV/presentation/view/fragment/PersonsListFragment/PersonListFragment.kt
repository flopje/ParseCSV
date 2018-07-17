package com.flowapps.parseCSV.presentation.view.fragment.PersonsListFragment


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flowapps.parseCSV.R
import com.flowapps.parseCSV.databinding.FragmentPersonListBinding
import com.flowapps.parseCSV.presentation.view.adapter.PersonAdapter
import com.flowapps.parseCSV.presentation.viewmodel.PersonListViewModel
import kotlinx.android.synthetic.main.fragment_person_list.*

class PersonListFragment : Fragment() {

    private val personAdapter: PersonAdapter = PersonAdapter()
    private lateinit var mainBinding: FragmentPersonListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_list, container, false)
        mainBinding.isLoading = true
        return mainBinding.root
    }

    override fun onStart() {
        super.onStart()

        recyclerview.addItemDecoration(DividerItemDecoration(recyclerview.context, DividerItemDecoration.VERTICAL))
        recyclerview.adapter = personAdapter

        val personListViewModel: PersonListViewModel = ViewModelProviders.of(this).get(PersonListViewModel::class.java)
        observeViewModel(personListViewModel)
    }

    private fun observeViewModel(personListViewModel: PersonListViewModel) {
        personListViewModel.getData().observe(this, Observer { persons ->
            personAdapter.setData(persons)
            personAdapter.notifyDataSetChanged()
            mainBinding.isLoading = false

        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment PersonListFragment.
         */
        @JvmStatic
        fun newInstance() = PersonListFragment()
    }
}
