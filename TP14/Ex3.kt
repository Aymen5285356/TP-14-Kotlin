package TP14

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val temps = measureTimeMillis {
        val a = async {
            delay(1000)
            10
        }
        val b = async {
            delay(2000)
            20
        }
        val c = async {
            delay(1500)
            30
        }

        println("Resultat a : ${a.await()}")
        println("Resultat b : ${b.await()}")
        println("Resultat c : ${c.await()}")
        println("Somme : ${a.await() + b.await() + c.await()}")
    }
    println("Temps total : $temps ms")
}
