package com.example.room

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.room.PersonApp.Companion.app
import com.example.room.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var peopleList: MutableList<Person>
    lateinit var adapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peopleList = ArrayList()
        getPeoples()
        binding.btnAddPeople.setOnClickListener { addPeople(Person( name = binding.etName.text.toString() )) }
        binding.btnNextActivity.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        setUpRecyclerView(peopleList )
    }

    private fun addPeople(person: Person) {

        doAsync {
            val id = app.personDao().insertPeople(person)
            val recoveryPerson = app.personDao().getById(id)
            uiThread {
                peopleList.add(recoveryPerson)
                adapter.notifyItemInserted(peopleList.size)
                clearFocus()
                hideKeyboard()
            }
        }
    }

    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private fun clearFocus() {
        binding.etName.setText("")
    }

    private fun setUpRecyclerView(peopleList: MutableList<Person>) {
        adapter = PeopleAdapter(peopleList, {updatePeople(it)}, {deletePeople(it)})
        recyclerView = findViewById(R.id.rvPeoples)
        //recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun updatePeople(person: Person) {
        doAsync {
            person.isDone = !person.isDone
            app.personDao().update(person)

        }

    }

    private fun deletePeople(person: Person) {
        doAsync {
            val position = peopleList.indexOf(person)
            app.personDao().delete(person)
            peopleList.remove(person)
            uiThread {
                adapter.notifyItemRemoved(position)
            }
        }
    }

    private fun getPeoples() {

        lifecycleScope.launch {
            whenStarted {
                binding.loadRoom.visibility= View.VISIBLE
                peopleList = app.personDao().getAll()
            }
            binding.loadRoom.visibility= View.GONE
            setUpRecyclerView(peopleList)
        }
    }

    private fun initActivity() {
        binding.btnNextActivity.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}
