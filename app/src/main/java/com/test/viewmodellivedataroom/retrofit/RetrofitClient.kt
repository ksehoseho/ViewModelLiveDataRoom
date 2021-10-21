package com.test.viewmodellivedataroom.retrofit

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// object -> 싱글턴
object RetrofitClient {
    // 레트로핏 클라이언트 선언
    private var retrofitClient: Retrofit? = null

    // 레트로핏 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d("test", "RetrofitClient - getClient() called")

        if(retrofitClient == null) {

            // 레트로핏 빌더
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())  // Gson 사용
                .build()
        }

        return retrofitClient
    }
}