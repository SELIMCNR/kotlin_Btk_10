package com.example.kotlin_btk_10.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class Besindata (
        @ColumnInfo(name = "isim")
        @SerializedName("isim")
        val isim: String?,
        @ColumnInfo(name = "kalori")
        @SerializedName("kalori")
        val kalori: String?,
        @ColumnInfo(name = "karbonhidrat")
        @SerializedName("karbonhidrat")
        val karbonhidrat: String?,
        @ColumnInfo(name = "protein")
        @SerializedName("protein")
        val protein: String?,
        @SerializedName("yag")
        @ColumnInfo(name = "yag")
        val yag: String?,
        @SerializedName("gorsel")
        @ColumnInfo(name = "gorsel")
        val gorsel: String?
)
{
        @PrimaryKey(autoGenerate = true)
        var uuid : Int = 0

}