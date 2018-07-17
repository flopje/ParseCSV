package com.flowapps.parseCSV.presentation.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.flowapps.parseCSV.R
import com.flowapps.parseCSV.databinding.RecyclerviewRowBinding
import com.flowapps.parseCSV.presentation.view.fragment.PersonsListFragment.PersonListFragment
import com.flowapps.parseCSV.service.models.Person


class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    private var personList: List<Person>? = null

    fun setData(data: List<Person>?) {
        this.personList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.recyclerview_row,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {
        return personList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        personList?.get(position)?.let { person ->
            with(holder) {
                bind(person)
                itemView.tag = person.id
            }
        }
    }

    private fun createOnClickListener(personId: Int) : View.OnClickListener {
        return View.OnClickListener {
            val direction = PersonListFragmentDirections
        }
    }


    class ViewHolder(private var binding: RecyclerviewRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person?) {
            with(binding) {
                this.person = person
            }
            binding.executePendingBindings()
        }
    }
}