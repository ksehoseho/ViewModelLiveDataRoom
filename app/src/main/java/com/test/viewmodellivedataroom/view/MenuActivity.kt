package com.test.viewmodellivedataroom.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.test.viewmodellivedataroom.R
import com.test.viewmodellivedataroom.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)

        binding.btnRoom.setOnClickListener() {
            val intent = Intent(this, RoomTestActivity::class.java)
            startActivity(intent)
        }

        binding.btnRetrofit.setOnClickListener() {
            val intent = Intent(this, RetrofitActivity::class.java)
            startActivity(intent)
        }
    }
}