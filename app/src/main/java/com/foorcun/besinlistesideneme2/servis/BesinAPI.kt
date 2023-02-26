package com.foorcun.besinlistesideneme2.servis

import com.foorcun.besinlistesideneme2.model.Besin
import io.reactivex.Single
import retrofit2.http.GET

interface BesinAPI {


    // source url : https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    // BASE_URL : https://raw.githubusercontent.com/
    // tail : atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    // https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesinler() : Single<List<Besin>>




}