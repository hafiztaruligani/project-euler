import java.math.MathContext
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private fun ans() {
    var x = (2).toBigDecimal(MathContext())
    var n = 1
    while (true) {
        println("$n ${x.toString().length}")
        n++
        x *= x
    }
}