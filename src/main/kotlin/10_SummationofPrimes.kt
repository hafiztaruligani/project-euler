import common.isPrime
import java.math.BigInteger
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private fun ans() {
    var sum = BigInteger.ZERO
    for (i in 1..2000000 step 2) {
        if (i.isPrime()) {
            sum += i.toBigInteger()
        }
    }
    println(sum+BigInteger.ONE)
}