package com.khs.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            //글로벌 스코프
            //앱의 생명주기와 함께 동작한다
            //시작부터 종료까지 긴 기간 실행되는 코루틴의 경우에 사용하기 적합하다
        }

        CoroutineScope(Dispatchers.IO).launch {
            //코루틴 스코프
            //필요할 때만 열고 완료시에 닫아주면 되는 코루틴
        }

        //-------------------------------------------------------------------

        //코루틴 스코프의 경우 디스패쳐로 코루틴이 실행될 스레드를 정해줄 수 있다.
        CoroutineScope(Dispatchers.Main).launch {
            //안드로이드 기본 스레드에서 코루틴을 실행한다
            //UI와의 상호작용에 최적화 되어있다.
        }

        CoroutineScope(Dispatchers.IO).launch {
            //입출력에 최적화 되어있는 디스패쳐이다
            //네트워크, DB 작업등에 적합하다
        }

        CoroutineScope(Dispatchers.Default).launch {
            //안드로이드 기본 스레드에서 코루틴을 실행한다.
            //데이터 정렬이나 복잡한 연산등 CPU를 많이 사용하는 작업에 최적화된 디스패쳐이다.
        }

        CoroutineScope(Dispatchers.Unconfined).launch {
            //호츌한 컨텍스트를 기본으로 사용한다
            //하지만 스코프 중단 후 재시작 될때 컨텍스트가 바뀌면 변경된 컨텍스트를 따라간다
        }
    }
}