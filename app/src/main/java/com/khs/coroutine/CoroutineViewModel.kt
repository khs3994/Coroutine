package com.khs.coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoroutineViewModel : ViewModel() {
    fun coroutine() = viewModelScope.launch {
        //뷰모델 스코프
        //뷰모델 안에서 사용하기 위해 제공되는 코루틴 스코프
        //이 스코프는 뷰모델 인스턴스가 소멸될때 자동으로 취소된다.
    }
}