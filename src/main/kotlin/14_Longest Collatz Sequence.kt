import java.math.BigDecimal
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private val list = hashMapOf<BigDecimal,BigDecimal>()
private fun ans() {
    var max = BigDecimal.ZERO
    var result = BigDecimal.ZERO
    repeat(999999) {

        var n = it.toBigDecimal()
        var counter = BigDecimal.ONE

        while (n> BigDecimal.ONE) {

            if (list[n]!=null) {
                counter+=list[n]!!
                break
            }

            if (n%(2).toBigDecimal()!= BigDecimal.ZERO) {
                n = ((3).toBigDecimal() * n) + BigDecimal.ONE
            }
            else n/=(2).toBigDecimal()
            counter++

        }

        if (counter>max) {
            max = counter
            result = it.toBigDecimal()
        }

        list[it.toBigDecimal()] = counter

    }
    println(result)
}
