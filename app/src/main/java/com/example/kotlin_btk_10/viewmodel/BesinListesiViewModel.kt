package com.example.kotlin_btk_10.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlin_btk_10.model.Besindata
import com.example.kotlin_btk_10.roomdb.BesinDatabase

import com.example.kotlin_btk_10.service.BesinAPIService
import com.example.kotlin_btk_10.util.OzelSharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BesinListesiViewModel(application: Application) : AndroidViewModel(application)   {

    val besinler = MutableLiveData<List<Besindata>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()


    private  val besinAPIService = BesinAPIService()
    private  val ozelSharedPreferences  = OzelSharedPreferences(getApplication())

    private val guncellemeZamani = 0.1 * 60 * 1000 * 1000*1000L

    fun refreshData(){
        val  kaydedilmeZamani = ozelSharedPreferences.zamaniAl()
        if (kaydedilmeZamani !=null && kaydedilmeZamani!=0L && System.nanoTime() - kaydedilmeZamani < guncellemeZamani){
            //roomdan verileri alacağız
            verileriRoomdanAl()
        }
        else {
            verileriInternettenAl()
        }
    }
    fun refreshDataFromInternet(){
        verileriInternettenAl()
    }
    private  fun verileriRoomdanAl(){
        besinYukleniyor.value = true

        viewModelScope.launch (Dispatchers.IO){
            val besinListesi = BesinDatabase(getApplication()).besinDao().gettAllBesin()
            withContext(Dispatchers.Main){
                besinleriGoster(besinListesi)
                Toast.makeText(getApplication(),"Besinleri roomdan aldım",Toast.LENGTH_LONG).show()
            }
        }
    }

    private  fun verileriInternettenAl(){

        besinYukleniyor.value = true


        viewModelScope.launch (Dispatchers.IO){
            val besinListesi = besinAPIService.getData()
            withContext(Dispatchers.Main){
                besinler.value = besinListesi

                besinYukleniyor.value = false
                //Room'a kaydedeceğiz
                roomaKaydet(besinListesi)
                Toast.makeText(getApplication(),"Besinleri internetten aldım",Toast.LENGTH_LONG).show()
            }
        }

    }

    private  fun besinleriGoster(besinListesi: List<Besindata>){
        besinler.value = besinListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false
    }

    private  fun roomaKaydet(besinListesi: List<Besindata>){
        viewModelScope.launch {
            val dao = BesinDatabase(getApplication()).besinDao()
            dao.deleteAllBesin()

            val uuidListesi = dao.insertAll(*besinListesi.toTypedArray())
            var i = 0
            while (i < besinListesi.size){
                besinListesi[i].uuid = uuidListesi[i].toInt()
                i = i + 1
            }

            besinleriGoster(besinListesi)
        }
        ozelSharedPreferences.zamaniKaydet(System.nanoTime())

    }

}