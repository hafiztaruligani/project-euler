import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private fun ans() {
    val list = (1..1000).toList()
    while (true) {
        for (i in 0..list.size) {
            for (j in i+1 until list.size) {
                for (k in j+1 until list.size) {

                    val a = list[i]
                    val b = list[j]
                    val c = list[k]
                    if (
                        a+b+c==1000
                        && ( (a*a)+(b*b)==c*c )
                    )
                    println( "$a $b $c ${a*b*c}" )
                }
            }
        }
        return
    }
}