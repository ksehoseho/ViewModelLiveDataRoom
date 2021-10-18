package com.test.viewmodellivedataroom.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.viewmodellivedataroom.data.UserInfo

class MainViewModel : ViewModel() {

    //var strInput = MutableLiveData<String>()
    var strInput: String = ""

    // 수정 가능한 LiveData
    private val userInfo = MutableLiveData<UserInfo>()

    fun setUserInfo(item: UserInfo) {
        userInfo.value = item
    }

    fun getUserInfo(): MutableLiveData<UserInfo> {
        return userInfo
    }
}