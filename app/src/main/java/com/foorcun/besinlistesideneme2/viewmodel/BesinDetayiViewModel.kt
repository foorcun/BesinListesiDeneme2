package com.foorcun.besinlistesideneme2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.foorcun.besinlistesideneme2.model.Besin

class BesinDetayiViewModel : ViewModel() {

    val besinSecilen  = MutableLiveData<Besin>()



    fun roomVerisiAl(){
        val muz = Besin("muz" ,"100","10","5","1","test.com")
        besinSecilen.value = muz
    }

}