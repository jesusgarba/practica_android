package com.example.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PeopleAdapter(

    val peopleList: MutableList<Person>,
    val checkPeople: (Person) -> Unit,
    val deletePeople: (Person) -> Unit ): RecyclerView.Adapter<PeopleAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_people, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = peopleList[position]
        holder.bind(item, checkPeople, deletePeople)
    }

    override fun getItemCount() = peopleList.size


    class ViewHolder (view: View): RecyclerView.ViewHolder(view){

        val tvName = view.findViewById<TextView>(R.id.tvName)
        val cbIsDone = view.findViewById<CheckBox>(R.id.cbIsDone)

        fun bind(people: Person, checkPeopleFunc: (Person) -> Unit, deletePeopleFunc: (Person) -> Unit){
            tvName.text = people.name
            cbIsDone.isChecked = people.isDone
            cbIsDone.setOnClickListener{checkPeopleFunc(people)}
            itemView.setOnClickListener { deletePeopleFunc(people)  }
        }




    }

}



