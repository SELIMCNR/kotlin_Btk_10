package com.example.kotlin_btk_10.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlin_btk_10.model.Besindata
import com.example.kotlin_btk_10.roomdb.BesinDatabase
import kotlinx.coroutines.launch

class BesinDetayViewModel(application: Application) :AndroidViewModel(application) {
    val besinLiveData = MutableLiveData<Besindata>()

    fun roomVerisiniAl(uuid : Int){
        viewModelScope.launch {
            val dao = BesinDatabase(getApplication()).besinDao()
            val besin = dao.getBesin(uuid)
            besinLiveData.value = besin
        }
    }
}