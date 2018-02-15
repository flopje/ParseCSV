package com.flowapps.parseCSV.util.extensions

import android.arch.lifecycle.LifecycleOwner
import android.util.Log
import com.flowapps.parseCSV.util.listeners.CoroutineLifecycleListener
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

internal val Background = newFixedThreadPoolContext(2, "bg")

fun <T> LifecycleOwner.load(loader: suspend () -> T): Deferred<T> {
    val deferred = async(context = Background,
            start = CoroutineStart.LAZY) {
        loader()
    }

    lifecycle.addObserver(CoroutineLifecycleListener(deferred))
    return deferred
}

infix fun <T> Deferred<T>.then(block: suspend (T) -> Unit): Job {
    return launch(context = UI) {
        try {
            block(this@then.await())
        } catch (e: Exception) {
            Log.e(e.message, e.stackTrace.toString())
        }
    }
}