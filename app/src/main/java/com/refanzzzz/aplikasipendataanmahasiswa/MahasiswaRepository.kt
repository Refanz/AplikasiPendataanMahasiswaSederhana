package com.refanzzzz.aplikasipendataanmahasiswa

import android.provider.ContactsContract.Data
import com.google.firebase.database.DatabaseError

class MahasiswaRepository {

    var mahasiswaDAO:MahasiswaDAO

    init {
        mahasiswaDAO = MahasiswaDAO()
    }

    fun addUser(mahasiswa: Mahasiswa, callback:OnDataCallback) {
        mahasiswaDAO.addMahasiswa(mahasiswa, object : MahasiswaDAO.OnDataCallback {
            override fun onSuccess() {
                callback.onSuccess()
            }

            override fun onError(e: Exception) {
                callback.onError(e)
            }
        })
    }

    interface OnDataCallback {
        fun onSuccess()
        fun onError(e:Exception)
    }
}