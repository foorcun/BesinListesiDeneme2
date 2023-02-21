package com.foorcun.besinlistesideneme2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.foorcun.besinlistesideneme2.model.Besin

class BesinListesiViewModel :ViewModel() {
    val besinler  = MutableLiveData<List<Besin>>()
    val besinHataMesaji =MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()


    fun refreshData(){
        val muz = Besin("muz" ,"100","10","5","1","test.com")
        val cilek = Besin("cilek" ,"100","10","5","1","test.com")
        val ayva = Besin("ayva" ,"100","10","5","1","test.com")

        val besinListesi = arrayListOf<Besin>(muz,cilek,ayva)

        besinler.value = besinListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false
    }
}