package com.example.nero.purse.purse

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.nero.purse.R
import com.example.nero.purse.database.purse.Purse
import com.example.nero.purse.database.purse.PurseViewModel
import com.example.nero.purse.purse.create.PurseCreateActivity
import com.example.nero.purse.purse.update.PurseUpdateActivity

import kotlinx.android.synthetic.main.activity_purse.*
import kotlinx.android.synthetic.main.content_purse.rv_list_purse

class PurseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purse)
        setSupportActionBar(toolbar)
        //Button
        fab.setOnClickListener { view ->
            onCreatePurse()
        }
        val adapter = PurseAdapter(this) { purse: Purse ->
            onUpdatePurse(purse)
        }
        rv_list_purse.layoutManager = LinearLayoutManager(this)
        rv_list_purse.adapter = adapter

        val purseViewModel: PurseViewModel = ViewModelProviders.of(this).get(PurseViewModel::class.java)
        purseViewModel.allPurse.observe(this, Observer { purse ->
            purse?.let { adapter.updatePurseList(it) }
        })
    }

    private fun onCreatePurse() {
        startActivity(Intent(this, PurseCreateActivity::class.java))
    }

    private fun onUpdatePurse(purse: Purse) {
        startActivity(Intent(this, PurseUpdateActivity::class.java).putExtra("purse", purse))
    }
}
