@file:OptIn(DelicateCoroutinesApi::class)

package com.example

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private val _refreshOrderEvent = MutableSharedFlow<Unit>(
    replay = 1,
    onBufferOverflow = BufferOverflow.DROP_OLDEST,
)
private val _selectedOrder = MutableStateFlow<String?>(null)

fun main(args: Array<String>) = runBlocking {
    _selectedOrder.combine(_refreshOrderEvent) { selected, _ ->
        println("combine $selected")
    }
    init()
    GlobalScope.launch {
        _selectedOrder.emit(null)
    }
}

private fun init() {
    GlobalScope.launch {
        _refreshOrderEvent.emit(Unit)
    }
}