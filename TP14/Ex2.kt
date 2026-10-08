package TP14

import kotlinx.coroutines.*

fun main() = runBlocking {
    val calcul = launch(Dispatchers.Default) {
        println("Calcul demarre sur ${Thread.currentThread().name}")
        delay(1000)
        println("Calcul termine")
    }

    val lecture = launch(Dispatchers.IO) {
        println("Lecture fichier demarree sur ${Thread.currentThread().name}")
        delay(2000)
        println("Lecture fichier terminee")
    }

    val reseau = launch(Dispatchers.IO) {
        println("Appel reseau demarre sur ${Thread.currentThread().name}")
        delay(1500)
        println("Appel reseau termine")
    }

    joinAll(calcul, lecture, reseau)
    println("Toutes les coroutines sont terminees")
}
