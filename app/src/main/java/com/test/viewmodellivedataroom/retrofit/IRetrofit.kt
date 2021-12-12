package com.test.viewmodellivedataroom.retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IRetrofit {

    // http://m.bus.go.kr/mBus/bus/getBusRouteList.bms?strSrch=5522
    @POST("/mBus/bus/getBusRouteList.bms")
    fun searchRoute(@Query("strSrch") strSrch: String) : Call<JsonElement>

    // http://m.bus.go.kr/mBus/bus/getSearchByName.bms?stSrch=%25EB%25A7%2588%25EC%259D%2584
    @GET("/mBus/bus/getSearchByName.bms")
    fun searchStation(@Query("stSrch") stSrch: String) : Call<JsonElement>

}


/*
통신할 API 정리
IRetrofitSeoul
IRetrofitGG
IRetrofitIC
 */