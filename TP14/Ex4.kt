package TP14

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job1 = launch {
        repeat(5) {
            println("Job 1 : etape ${it + 1}")
            delay(500)
        }
    }

    val job2 = launch {
        repeat(5) {
            println("Job 2 : etape ${it + 1}")
            delay(500)
        }
    }

    val job3 = launch {
        delay(1000)
        println("Job 3 termine")
    }

    delay(1200)
    println("Job 1 actif : ${job1.isActive}")
    job2.cancel()
    println("Job 2 annule")

    job1.join()
    job2.join()
    job3.join()

    println("Job 1 actif : ${job1.isActive}")
    println("Job 2 actif : ${job2.isActive}")
    println("Job 3 actif : ${job3.isActive}")
}
