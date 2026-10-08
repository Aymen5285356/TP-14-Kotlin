package TP14

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val nombres = flow {
        for (i in 1..10) {
            emit(i)
        }
    }

    println("Flow brut :")
    nombres.collect { println(it) }

    println("map (x2) :")
    nombres.map { it * 2 }.collect { println(it) }

    println("filter (pairs) :")
    nombres.filter { it % 2 == 0 }.collect { println(it) }

    println("take (3 premiers) :")
    nombres.take(3).collect { println(it) }

    println("filter + map + take :")
    nombres
        .filter { it % 2 == 0 }
        .map { it * 10 }
        .take(3)
        .collect { println(it) }
}
