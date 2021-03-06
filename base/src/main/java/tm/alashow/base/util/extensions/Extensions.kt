/*
 * Copyright (C) 2018, Alashov Berkeli
 * All rights reserved.
 */
package tm.alashow.base.util.extensions

import java.util.*
import kotlin.math.max

typealias Callback = () -> Unit

fun now() = System.currentTimeMillis()
fun nowNano() = System.nanoTime()

fun Array<out Any>.asString(): String {
    return joinToString { it.toString() }
}

typealias Toggle = (Boolean) -> Unit

val pass: Unit = Unit

/**
 * Cast given variable to [T] and run [block] if it's the same cast as [T].
 * @param to cast to
 * @param fallback will be called if it's not a match
 * @param block will be called if it's a match
 */
inline fun <reified T> cast(to: Any?, fallback: () -> Unit = {}, block: (T) -> Unit) {
    if (to is T) {
        block(to)
    } else {
        fallback()
    }
}

fun randomUUID(): String = UUID.randomUUID().toString()

/**
 * Run [block] only if [api] is >= than device's SDK version.
 */
fun whenApiLevel(api: Int, block: () -> Unit) {
    if (api >= android.os.Build.VERSION.SDK_INT) {
        block()
    }
}

infix fun Float.muteUntil(that: Float) = max(this - that, 0.0f) * (1 / (1 - that))
