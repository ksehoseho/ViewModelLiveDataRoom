package com.test.viewmodellivedataroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.test.viewmodellivedataroom.Constants
import com.test.viewmodellivedataroom.R
import com.test.viewmodellivedataroom.databinding.ActivityRetrofitBinding
import com.test.viewmodellivedataroom.retrofit.RetrofitManager

class RetrofitActivity : AppCompatActivity() {

    lateinit var binding: ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)

        binding.btnSearchRt.setOnClickListener() {
            RetrofitManager.instance.searchRoute(strQuery = "5522", completion = {
                resState, responseBody ->
                when(resState) {
                    Constants.RES_STATE.OK ->
                        Log.d("test", "성공!!")
                    Constants.RES_STATE.FAIL ->
                        Log.d("test", "실패!!")
                }
            })
        }

        binding.btnSearchSt.setOnClickListener() {
            RetrofitManager.instance.searchStation(strQuery = "kt", completion = {
                    resState, responseBody ->
                when(resState) {
                    Constants.RES_STATE.OK ->
                        Log.d("test", "성공!!")
                    Constants.RES_STATE.FAIL ->
                        Log.d("test", "실패!!")
                }
            })
        }

    }
}