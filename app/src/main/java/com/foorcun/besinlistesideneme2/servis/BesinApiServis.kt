package com.foorcun.besinlistesideneme2.servis

import com.foorcun.besinlistesideneme2.model.Besin
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BesinApiServis {

    // source url : https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    // BASE_URL : https://raw.githubusercontent.com/
    // tail : atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    // https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json


    private val BASE_URL = "https://raw.githubusercontent.com/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(BesinAPI::class.java)


    fun getData()   : Single<List<Besin>>{
        return api.getBesinler()
    }

}