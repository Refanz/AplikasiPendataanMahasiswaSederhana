package com.refanzzzz.aplikasipendataanmahasiswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var btnAdd:Button
    private lateinit var rvMahasiswa:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        initListener()
    }

    private fun init() {
        btnAdd = findViewById(R.id.btnAddMahasiswa)
        rvMahasiswa = findViewById(R.id.rvMahasiswa)
    }

    private fun initListener() {
        btnAdd.setOnClickListener {
            val intent = Intent(this, AddMahasiswaActivity::class.java)
            startActivity(intent)
        }
    }
}