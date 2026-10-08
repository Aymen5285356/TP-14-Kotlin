package TP14


import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val debut = System.currentTimeMillis()

    GlobalScope.launch {
        delay(1000)
        println("GlobalScope : telechargement termine")
    }

    val scope = CoroutineScope(Dispatchers.Default)

    val traitement = scope.launch {
        delay(2000)
        println("CoroutineScope : traitement termine")
    }

    val tacheAnnulee = scope.launch {
        delay(4000)
        println("Cette ligne ne s'affiche jamais")
    }

    runBlocking {
        delay(500)
        tacheAnnulee.cancel()
        println("Tache annulee")
        traitement.join()
        delay(1000)
        println("Temps total : ${System.currentTimeMillis() - debut} ms")
    }
}