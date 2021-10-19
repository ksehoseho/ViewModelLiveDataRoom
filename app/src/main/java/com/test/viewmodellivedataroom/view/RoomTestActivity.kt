package com.test.viewmodellivedataroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.test.viewmodellivedataroom.R
import com.test.viewmodellivedataroom.database.AppDatabase
import com.test.viewmodellivedataroom.database.Todo
import com.test.viewmodellivedataroom.databinding.ActivityRoomTestBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomTestActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_test)

        // LiveData 적용을 위해 (없으면 xml 갱신이 안됨)
        binding.lifecycleOwner = this

        // 뷰모델
        val viewModel = ViewModelProvider(this).get(RoomTestViewModel::class.java)
        binding.viewModel = viewModel  // xml과 바인딩

        // xml에서 갱신
        /*// UI 갱신 (LiveData)
        viewModel.getAll().observe(this) {
            binding.tvResult.text = it.toString()
        }*/

        // xml에서 실행
        /*binding.btnSave.setOnClickListener() {
            // 코루틴, 백그라운드 동작
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(Todo(binding.etInput.text.toString()))
            }
        }*/
    }
}