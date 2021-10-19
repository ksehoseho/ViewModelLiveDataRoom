package com.test.viewmodellivedataroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.test.viewmodellivedataroom.R
import com.test.viewmodellivedataroom.data.UserInfo
import com.test.viewmodellivedataroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private val mainViewModel: MainViewModel by viewModels()
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.lifecycleOwner = this

        // 뷰모델 초기화
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModelData()

        binding.btnInput.setOnClickListener() {
            val strInput = binding.etInput.text.toString()
            //binding.tvResult.text = strInput
            mainViewModel.strInput = strInput
            viewModelData()
        }

        // LiveData 테스트
        setUserInfoData()

        binding.btnName.setOnClickListener() {
            val userInfo = mainViewModel.getUserInfo()
            val userName = binding.etName.text.toString()
            userInfo.value!!.name = userName
            mainViewModel.setUserInfo(userInfo.value!!)
        }

        mainViewModel.getUserInfo().observe(this) {
            Log.e("test", "observe!!!!")
            val userName = mainViewModel.getUserInfo().value!!.name
            binding.tvResultName.text = userName
        }
    }

    // 뷰모델의 문자열 출력
    private fun viewModelData() {
        binding.tvResult.text = mainViewModel.strInput
    }

    private fun setUserInfoData() {
        val userInfo = UserInfo(name = "myName")
        mainViewModel.setUserInfo(userInfo)
    }
}