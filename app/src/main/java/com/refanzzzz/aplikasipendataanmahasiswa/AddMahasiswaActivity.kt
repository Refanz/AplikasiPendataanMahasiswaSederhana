package com.refanzzzz.aplikasipendataanmahasiswa

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddMahasiswaActivity : AppCompatActivity() {

    private lateinit var etNIM: EditText
    private lateinit var etNama: EditText
    private lateinit var btnAdd: Button
    private lateinit var mahasiswaRepository: MahasiswaRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_mahasiswa)

        init()

        initMahasiswaRepo()

        btnAdd.setOnClickListener {

            if (etNama.text.isNullOrBlank() || etNIM.text.isNullOrBlank()) {
                Toast.makeText(this, "Field masih kosong!", Toast.LENGTH_SHORT).show()
            } else {
                val id = "1"
                val mahasiswa = Mahasiswa(id, etNIM.text.toString(), etNama.text.toString(), "")

                mahasiswaRepository.addUser(mahasiswa, object : MahasiswaRepository.OnDataCallback {
                    override fun onSuccess() {
                        Log.d("MahasiswaRepository", "Mahasiswa berhasil ditambah")
                        Toast.makeText(applicationContext, "Data berhasil ditambah", Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(e: Exception) {
                        Log.d("MahasiswaRepository", "Mahasiswa gagal ditambah!")
                        Toast.makeText(applicationContext, "Data gagal ditambah!", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }

    private fun init() {
        etNama = findViewById(R.id.etNama)
        etNIM = findViewById(R.id.etNIM)
        btnAdd = findViewById(R.id.btnAdd)
    }

    private fun initMahasiswaRepo() {
        mahasiswaRepository = MahasiswaRepository()
    }
}