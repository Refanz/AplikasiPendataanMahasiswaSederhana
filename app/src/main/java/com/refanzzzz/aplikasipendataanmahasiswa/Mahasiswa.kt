package com.refanzzzz.aplikasipendataanmahasiswa

import android.os.Parcel
import android.os.Parcelable

data class Mahasiswa(val id:String?, val nim:String?, val nama:String?, val photo:String?) : Parcelable  {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.id)
        dest.writeString(this.nama)
        dest.writeString(this.nim)
        dest.writeString(this.photo)
    }

    companion object CREATOR : Parcelable.Creator<Mahasiswa> {
        override fun createFromParcel(parcel: Parcel): Mahasiswa {
            return Mahasiswa(parcel)
        }

        override fun newArray(size: Int): Array<Mahasiswa?> {
            return arrayOfNulls(size)
        }
    }
}