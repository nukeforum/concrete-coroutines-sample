package com.example.coroutinessample

import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CoroutineDemo : CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    fun run(container: TextView) {
        launch {
            val awaiter = Suspendables.futureWorld()

            //work to do in the meantime

            container.text = awaiter.await()
        }
    }
}