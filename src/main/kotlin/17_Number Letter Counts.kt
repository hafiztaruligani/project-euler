import common.pow
import java.lang.NumberFormatException
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private fun ans() {
    val listOfWord = hashMapOf<Int, String>()
    listOfWord[1] = "one"
    listOfWord[2] = "two"
    listOfWord[3] = "three"
    listOfWord[4] = "four"
    listOfWord[5] = "five"
    listOfWord[6] = "six"
    listOfWord[7] = "seven"
    listOfWord[8] = "eight"
    listOfWord[9] = "nine"
    listOfWord[10] = "ten"
    listOfWord[11] = "eleven"
    listOfWord[12] = "twelve"
    listOfWord[1000] = "one thousand"

    val listOfSecondWord = hashMapOf<Int, String>()
    listOfSecondWord[1] = "one"
    listOfSecondWord[2] = "twen"
    listOfSecondWord[3] = "thir"
    listOfSecondWord[4] = "four"
    listOfSecondWord[5] = "fif"
    listOfSecondWord[6] =  "six"
    listOfSecondWord[7] = "seven"
    listOfSecondWord[8] = "eight"
    listOfSecondWord[9] = "nine"


    repeat(1000) { asd ->
        val n = asd+1
        when (n) {
            in 13..19 -> listOfWord[n] = listOfSecondWord[n%10]+"teen"
            in 20..99 -> listOfWord[n] =
                if (n%10==0) listOfSecondWord[n.firstDigit()]+"ty"
                else  listOfSecondWord[n.firstDigit()]+"ty " + listOfWord[n.digitExceptFirst()]
            in 100 .. 999 -> {
                listOfWord[n] = listOfWord[n.firstDigit()] + " hundred" +
                        if (n%100==0) "" else {
                            " and " + listOfWord[n.digitExceptFirst()]
                        }

            }
        }

        if (listOfWord[n]?.contains("eightty")==true)
            listOfWord[n] = listOfWord[n]!!.replace("eightty", "eighty")
        if (listOfWord[n]?.contains("eightteen")==true)
            listOfWord[n] = listOfWord[n]!!.replace("eightteen", "eighteen")
        if (listOfWord[n]?.contains("fourty")==true)
            listOfWord[n] = listOfWord[n]!!.replace("fourty", "forty")

    }

    listOfWord.toList().sortedBy { it.first }.forEach {
        println(it.second)
    }
    var result = 0
    listOfWord.forEach {
        val tmp = it.value.replace("[", "")
        .replace("]","")
        .replace(",", "")
        .replace(" ", "")
        result+=tmp.length
    }
    println(result)
}

private fun Int.digitOf(i: Int): Int {
    return this.toString().get(i-1).toString().toInt()
}

private fun Int.digitExceptFirst(): Int {
    return this.toString().drop(1).toInt()
}

private fun Int.firstDigit(): Int {
    return this.toString().first().toString().toInt()
}