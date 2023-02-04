package com.refanzzzz.aplikasipendataanmahasiswa

import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MahasiswaDAO {

    var db:DatabaseReference

    init {
        db = FirebaseDatabase.getInstance().getReference("mahasiswa")
    }

    fun addMahasiswa(mahasiswa: Mahasiswa, callback: OnDataCallback) {
        val key =  db.child("mahasiswa").push().key

        db.child("mahasiswa").child(key!!).setValue(mahasiswa)
            .addOnSuccessListener {
                callback.onSuccess()
            }

            .addOnFailureListener { e ->
                callback.onError(e)
            }
    }

    interface OnDataCallback {
        fun onSuccess()
        fun onError(e: Exception)
    }


}