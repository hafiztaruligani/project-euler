import common.isPalindrome
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println(time)
}

private fun ans() {
    val primeList = mutableListOf<Int>()
    var max = 0
    for (i in 999 downTo 100) {
        for (j in i downTo 100) {
            val tmp = i*j
            if ( (tmp).isPalindrome() && max<tmp ) {
                println("$i $j ${i*j}")
                max = tmp
            }
        }
    }
    println(max)
}

