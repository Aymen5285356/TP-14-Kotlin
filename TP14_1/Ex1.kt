package tp14_1

import kotlinx.coroutines.*

suspend fun verifierDisponibilite() {
    println("Verification des ingredients...")
    delay(2000)
    println("Ingredients disponibles")
}

suspend fun preparerCommande() {
    println("Preparation de la commande...")
    delay(5000)
    println("Commande prete")
}

suspend fun livrerRepas() {
    withContext(Dispatchers.IO) {
        println("Livraison du repas...")
        delay(3000)
        println("Repas livre")
    }
}

fun main() = runBlocking {
    val debut = System.currentTimeMillis()

    val commande = launch {
        verifierDisponibilite()
        preparerCommande()
        livrerRepas()
    }

    commande.join()
    println("Temps total : ${System.currentTimeMillis() - debut} ms")
}
