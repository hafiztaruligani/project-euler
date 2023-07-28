import common.isPrime
import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private fun ans() {
    var listLength = 1
    var nn = 21
    var x = 7
    while (listLength<500) {
        var n = nn
        print("$n :")
        listLength = 1

        val limit = sqrt(n.toDouble())
        var divisor = 2
        while (divisor<limit) {

            var tmp = 0
            while (n%divisor==0) {
                n/=divisor
                tmp++
                print("$divisor ")
            }
            if (tmp>0) {
                listLength*=(tmp+1)
            }

            divisor++

        }
        println(" length = $listLength")

        nn+=x
        x++
    }
    println("result: nn=${nn - x+1}  listLength=$listLength")
}