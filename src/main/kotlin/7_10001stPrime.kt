import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}
private val primeList = mutableListOf(2,3,5,7,11,13)
private fun ans() {
    val n = 10001
    var x = primeList.last()+1
    while (primeList.size<n) {
        var isPrime = true
        val tmp = sqrt(x.toDouble()).toInt()
        for (i in 0 until primeList.size) {
            if (x%primeList[i]==0) {
                isPrime = false
                break
            }
        }
        if (isPrime) primeList.add(x)
        x++
    }
    println(primeList.last())
}