package com.example.coroutinessample

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

object Suspendables: CoroutineScope {
    private val internalContext = Dispatchers.IO
    override val coroutineContext: CoroutineContext
        get() = internalContext

    suspend fun hello(): String {
        println("getting hello on: ${Thread.currentThread().name}")
        delay(1000L)
        return "hello"
    }

    suspend fun world(): String {
        return withContext(internalContext) {
            println("getting world on: ${Thread.currentThread().name}")
            delay(1000L)
            "world"
        }
    }

    fun futureWorld(): Deferred<String> {
        return CoroutineScope(internalContext).async {
            println("getting world on: ${Thread.currentThread().name}")
            "world"
        }
    }
}