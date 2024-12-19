package com.example.kotlin_btk_10.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_btk_10.model.Besindata

@Dao
interface BesinDAO {

    @Insert
    suspend fun insertAll(vararg besin: Besindata): List<Long>

    @Query("SELECT * FROM  Besindata")
    suspend fun gettAllBesin(): List<Besindata>

    @Query("SELECT * FROM Besindata WHERE uuid = :besinId")
    suspend fun getBesin(besinId: Int): Besindata

    @Query("DELETE FROM Besindata")
    suspend fun  deleteAllBesin()

}