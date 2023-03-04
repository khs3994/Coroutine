package com.khs.coroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineStatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_status)

        // Cancel 에제
        val job = CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                Log.d("TAG", "반복문 실행")
                delay(100)
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            job.cancel()
        }

        //------------------------------------------------

        // join 예제

        CoroutineScope(Dispatchers.IO).launch {
            launch {
                println("1번 코루틴 실행")
                delay(500)
                println("딜레이 500 (1번)")
            }.join()

            launch {
                println("2번 코루틴 실행")
                delay(500)
                println("달레이 500 (2번)")
            }
        }
    }
}