package com.test.viewmodellivedataroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.test.viewmodellivedataroom.Constants
import com.test.viewmodellivedataroom.R
import com.test.viewmodellivedataroom.data.SUBusSearch
import com.test.viewmodellivedataroom.databinding.ActivityRetrofitBinding
import com.test.viewmodellivedataroom.retrofit.IRetrofit
import com.test.viewmodellivedataroom.retrofit.RetrofitClient
import com.test.viewmodellivedataroom.retrofit.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    lateinit var binding: ActivityRetrofitBinding

    private val  iRetrofit : IRetrofit? = RetrofitClient.getClient(Constants.API.BASE_URL)?.create(
        IRetrofit::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)

        binding.btnSearchRt.setOnClickListener() {
            //val query = strQuery ?: ""
            val call: Call<JsonElement> = iRetrofit?.searchRoute("5522").let {
                it!!
            }

            call.enqueue(object: retrofit2.Callback<JsonElement> {
                override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                    Log.e("test", "response.raw() : ${response.raw()}")
                    Log.e("test", "response.body() : ${response.body().toString()}")
                }

                override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                    Log.e("test", "onResponse() : ${t.printStackTrace()}")
                }

            })
        }



        /*binding.btnSearchRt.setOnClickListener() {
            RetrofitManager.instance.searchRoute(strQuery = "5522", completion = {
                resState, responseBody ->
                when(resState) {
                    Constants.RES_STATE.OK -> {
                    Log.d("test", "성공!!")
                        val gson = Gson()
                        val data = gson.fromJson(responseBody, SUBusSearch::class.java)
                        Log.e("test", "DATA :: ${data.resultList}")
                        Log.e("test", "DATA :: ${data.resultList[0].busRouteNm}")
                    }

                    Constants.RES_STATE.FAIL -> {
                        Log.d("test", "실패!!")
                    }
                }
            })
        }*/

        binding.btnSearchSt.setOnClickListener() {
            RetrofitManager.instance.searchStation(strQuery = "kt", completion = {
                    resState, responseBody ->
                when(resState) {
                    Constants.ResponseState.OK ->
                        Log.d("test", "성공!!")
                    Constants.ResponseState.FAIL ->
                        Log.d("test", "실패!!")
                }
            })
        }

    }
}