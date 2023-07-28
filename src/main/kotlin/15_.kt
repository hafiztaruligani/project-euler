import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private fun ans() {
    val n = 3
    val map = mutableListOf<MutableList<Int?>>()

    for (i in 0 until n+1) {
        val tmp = mutableListOf<Int?>()
        for (j in 0 until n+1) {
            if (i==n) {
                tmp.add(null)

            } else if (j!=n) tmp.add(-1)
            else tmp.add(null)
        }
        map.add(tmp)
    }

    var mark = 0

    var i = 0
    while (map.notFull()) {

        var jj = 0
        for (j in 0 ..n) {
            when {
                map[i][j + 1] == null -> {
                    break
                }
                i == 0 && j == 0 -> map[i][j] = mark
                map[i][j] == -1 -> map[i][j] = mark

            }
            jj = j
        }
        //mark++

        if (map[i+1][jj]==null) {
            break
        }
        i++
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            when {
                i==0 && j==0 -> map[i][j] = mark
                map[i][j] == -1 -> map[i][j] = mark

                map[i][j+1]==null -> break
                map[i+1][j]==null -> break
            }
        }
        mark++
    }

    map.forEach {
        it.forEach {
            if (it != null) {
                print("${it} ")
            }
        }
        println()
    }

}

private fun MutableList<MutableList<Int?>>.notFull(): Boolean {
    forEach {
        it.forEach {
            if (it==-1) return true
        }
    }
    return false
}


private fun MutableList<Int?>.notFull2(): Boolean {
    forEach {
        if (it==-1) return true
    }
    return false
}

