package com.khs.coroutine

import kotlinx.coroutines.*

fun main() {
    async()
}

fun launch() {
    val job = CoroutineScope(Dispatchers.IO).launch {
        delay(1000)
        println("courutine launch")
    }

    println("call in main")
    println("job isActive: ${job.isActive}, isCompleted: ${job.isCompleted}")
    Thread.sleep(5000)
    println("job isActive: ${job.isActive}, isCompleted: ${job.isCompleted}")
}

fun async() {
    println("coroutine start")
    CoroutineScope(Dispatchers.Default).launch {
        val job1 = async {
            delay(1000)
            "job1 !!"
        }

        val job2 = async {
            delay(3000)
            "job2 !!"
        }

        println("${job1.await()} | ${job2.await()}")
    }
}