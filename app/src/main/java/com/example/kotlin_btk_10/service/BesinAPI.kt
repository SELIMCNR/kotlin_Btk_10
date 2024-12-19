package com.example.kotlin_btk_10.service

import com.example.kotlin_btk_10.model.Besindata
import retrofit2.http.GET

interface BesinAPI {


    //Base URL -> https://raw.githubusercontent.com/
    //atilsamancioglu/BTK20-JSONVeriSeti/refs/heads/master/besinler.json


    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    suspend fun getBesinler(): List<Besindata>



}