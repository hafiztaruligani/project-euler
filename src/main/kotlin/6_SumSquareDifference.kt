import kotlin.math.abs
import kotlin.system.measureTimeMillis



fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private fun ans() {

    val n = 100

    var a = (1..n).sum()
    a *=a

    var b = 0
    (1..n).forEach {
        b+= it*it
    }

    println(abs( b-a ))
}
