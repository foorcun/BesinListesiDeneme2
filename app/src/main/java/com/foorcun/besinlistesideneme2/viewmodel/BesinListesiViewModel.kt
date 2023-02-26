package com.foorcun.besinlistesideneme2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.foorcun.besinlistesideneme2.model.Besin
import com.foorcun.besinlistesideneme2.servis.BesinApiServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class BesinListesiViewModel :ViewModel() {
    val besinler  = MutableLiveData<List<Besin>>()
    val besinHataMesaji =MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()


    private val besinApiServis = BesinApiServis()
    private val disposable = CompositeDisposable()

    fun refreshData(){
//        val muz = Besin("muz" ,"100","10","5","1","test.com")
//        val cilek = Besin("cilek" ,"100","10","5","1","test.com")
//        val ayva = Besin("ayva" ,"100","10","5","1","test.com")
//
//        val besinListesi = arrayListOf<Besin>(muz,cilek,ayva)
//
//        besinler.value = besinListesi
//        besinHataMesaji.value = false
//        besinYukleniyor.value = false

        verileriInternettenAl()
    }


    private fun verileriInternettenAl(){
        besinYukleniyor.value = true

        disposable.add(
            besinApiServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Besin>>(){
                    override fun onSuccess(t: List<Besin>) {
                        besinler.value = t
                        besinHataMesaji.value = false
                        besinYukleniyor.value = false

                        printAllBesinler()
                    }

                    override fun onError(e: Throwable) {
                        besinHataMesaji.value = true
                        besinYukleniyor.value = false
                        println("Hata burdan gelio")
                        e.printStackTrace()
                    }

                })
        )

    }

    fun printAllBesinler(){

        for (besin in besinler.value!!) {
            println(besin.toString())
        }
    }
}