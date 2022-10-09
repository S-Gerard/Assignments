package com.example.assignments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignments.R
import com.example.assignments.model.Assignment

class ItemAdapter(var items: MutableList<Assignment> = ArrayList()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val descriptionTextView = view?.findViewById(R.id.task_description) as? TextView
        val completedCheckBox = view?.findViewById(R.id.task_completed) as? CheckBox

        fun bindItem(item: Assignment) {
            descriptionTextView?.text = item.description
            completedCheckBox?.isChecked = item.completed

            completedCheckBox?.setOnCheckedChangeListener { buttonView, isChecked ->
                items[adapterPosition].completed = isChecked
            }
        }
    }
}