import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private fun ans() {
    println(
        (2).toBigDecimal()
            .pow(1000)
            .toString()
            .toList()
            .sumOf { it.toString().toInt() }
    )
}