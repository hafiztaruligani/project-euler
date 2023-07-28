package common

import kotlin.math.sqrt

fun main() {
    println((91).isPrime())
    println((101).isPrime())
    println((4).isPrime())
    println((7).isPrime())
}

fun Int.isPalindrome() : Boolean{
    val a = this.toString()
    return a==a.reversed()
}

fun Int.isPrime(): Boolean {
    val limit = sqrt(this.toDouble())
    var n = 2
    while (n<=limit) {
        if (this%n==0) return false
        n++
    }
    return true
}

fun Int.isOdd(): Boolean {
    return this % 2 != 0
}

fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun Int.pow(n: Int) : Int {
    var result = 1
    repeat(n) {
        result*=this
    }
    return result
}


