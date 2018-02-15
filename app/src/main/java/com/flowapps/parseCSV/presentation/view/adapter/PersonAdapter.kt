package com.flowapps.parseCSV.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.flowapps.parseCSV.databinding.RecyclerviewRowBinding
import com.flowapps.parseCSV.service.models.Person


class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    private var personList: List<Person>? = null

    fun setData(data: List<Person>?) {
        this.personList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val personBinding: RecyclerviewRowBinding = RecyclerviewRowBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(personBinding)
    }

    override fun getItemCount(): Int {
        return personList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: Person? = personList?.get(position)
        holder.bind(person)
    }


    class ViewHolder(private var binding: RecyclerviewRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person?) {
            binding.person = person
            binding.executePendingBindings()
        }
    }
}