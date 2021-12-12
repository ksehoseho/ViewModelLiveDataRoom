package com.test.viewmodellivedataroom.retrofit

import android.util.Log
import com.google.gson.JsonElement
import com.test.viewmodellivedataroom.Constants
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()
    }

    // 레트로핏 인터페이스 가져오기
    private val  iRetrofit : IRetrofit? = RetrofitClient.getClient(Constants.API.BASE_URL)?.create(IRetrofit::class.java)

    //
    fun searchRoute(strQuery: String?, completion: (Constants.ResponseState, String) -> Unit) {
        val query = strQuery ?: ""
        val call: Call<JsonElement> = iRetrofit?.searchRoute(query).let {
            it!!
        }

        call.enqueue(object: retrofit2.Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.e("test", "response.raw() : ${response.raw()}")
                Log.e("test", "response.body() : ${response.body().toString()}")
                completion(Constants.ResponseState.OK, response.body().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.e("test", "onFailure() : ${t.printStackTrace()}")
                completion(Constants.ResponseState.FAIL, t.toString())
            }

        })
    }

    fun searchStation(strQuery: String?, completion: (Constants.ResponseState, String) -> Unit) {
        val query = strQuery ?: ""
        val call: Call<JsonElement> = iRetrofit?.searchStation(query).let {
            it!!
        }

        call.enqueue(object: retrofit2.Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.e("test", "response.raw() : ${response.raw()}")
                Log.e("test", "response.body() : ${response.body().toString()}")
                completion(Constants.ResponseState.OK, response.body().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.e("test", "onFailure() : ${t.printStackTrace()}")
                completion(Constants.ResponseState.FAIL, t.toString())
            }

        })
    }

}
