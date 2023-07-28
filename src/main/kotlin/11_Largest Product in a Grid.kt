import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        ans()
    }
    println("\nTIME: $time ms")
}

private val list = listOf(
    listOf( 8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8,),
    listOf( 49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0,),
    listOf( 81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65,),
    listOf( 52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91,),
    listOf( 22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80,),
    listOf( 24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50,),
    listOf( 32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70,),
    listOf( 67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21,),
    listOf( 24, 55, 58, 5,  66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72,),
    listOf( 21, 36, 23, 9,  75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95,),
    listOf( 78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92,),
    listOf( 16, 39, 5,  42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57,),
    listOf( 86, 56, 0,  48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58,),
    listOf( 19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40,),
    listOf( 4,  52, 8,  83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66,),
    listOf( 88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69,),
    listOf( 4,  42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36,),
    listOf( 20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16,),
    listOf( 20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54,),
    listOf( 1,  70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48,),
)

private fun ans() {
    val n = 4

    //horizontalVertical(n)
    //diagonalDownLeftToRIght(4)
    //diagonalUpLeftToRight(4)


    merge(n)
    println(max) // 70600674

}

private fun merge(n: Int) {
    val tmpList = mutableListOf<Int>()
    val tmpList2 = mutableListOf<Int>()
    for (i in list.indices) {

        /** diagonalDownLeftToRIght half left **/
        var j = 0
        while (j!=list.size-i) {
            tmpList.add(list[j+i][j])
            j++
        }
        tmpList.countMax(n)
        tmpList.clear()

        /** diagonalUpLeftToRight half left **/
        j = 0
        while (j!=i+1) {
            tmpList.add(list[i-j][j])
            j++
        }
        tmpList.countMax(n)
        tmpList.clear()

        var k = i+1
        var x = 1
        while (k!=list.size) {
            /** diagonalDownLeftToRIght half right **/
            tmpList.add(list[x-1][k])

            /** diagonalUpLeftToRight half right **/
            tmpList2.add(list[list.size-x][k])

            k++
            x++
        }
        tmpList.countMax(n)
        tmpList.clear()
        tmpList2.countMax(n)
        tmpList2.clear()


        /** vertical horizontal **/
        for (j1 in 0 until list.size - n + 1) {
            for (h in j1 until j1 + n) {
                // vertical
                tmpList.add(list[h][i])

                // horizontal
                tmpList2.add(list[i][h])
            }
            tmpList.countMax(n)
            tmpList.clear()
            tmpList2.countMax(n)
            tmpList2.clear()
        }



    }
}

var max = 0

private fun MutableList<Int>.countMax(n: Int) {
    if (size<n) return
    for (i in 0 .. size-n) {
        var tmp = 1
        repeat(n) {
            tmp*=get(it+i)
        }
        if (tmp>max) max = tmp
    }
}

fun diagonalDownLeftToRIght(n: Int) {
    for (i in list.indices) {

        /** half left **/
        var j = 0
        val tmpList = mutableListOf<Int>()
        while (j!=list.size-i) {
            //print("${list[j+i][j]} ")
            //println("${j+i} ${j} ")
            tmpList.add(list[j+i][j])
            j++
        }
        tmpList.countMax(n)
        tmpList.clear()

        /** half right **/
        var k = i+1
        var x = 1
        while (k!=list.size) {
            // print("${list[x-1][k]} ")
            //println("${x-1} $k ")
            tmpList.add(list[x-1][k])
            k++
            x++
        }
        tmpList.countMax(n)
        tmpList.clear()


        println()
    }
}

fun diagonalUpLeftToRight(n: Int) {
    for (i in list.indices) {
        val tmpList = mutableListOf<Int>()

        /** half left **/
        var j = 0
        while (j!=i+1) {
            //print("${list[i-j][j]} ")
            tmpList.add(list[i-j][j])
            j++
        }
        tmpList.countMax(n)
        tmpList.clear()

        /** half right **/
        var k = i+1
        var x = 1
        while (k!=list.size) {
            //print("${list[list.size-x][k]} ")
            tmpList.add(list[list.size-x][k])
            k++
            x++
        }

        tmpList.countMax(n)
        tmpList.clear()

        println()
    }
}


private fun horizontalVertical(n: Int) {
    val tmpList = mutableListOf<Int>()
    val tmpList2 = mutableListOf<Int>()
    for (i in list.indices) {
        for (j in 0 until list.size - n + 1) {
            for (h in j until j + n) {
                // vertical
                //print("${list[h][i]} ")
                tmpList.add(list[h][i])

                // horizontal
                //if (j<list.size - n - 1)
                //     print("${list[i][h]} ")

                tmpList2.add(list[i][h])
            }
            tmpList.countMax(n)
            tmpList.clear()
            tmpList2.countMax(n)
            tmpList2.clear()
        }
        println()
    }
}

private fun horizontal(n: Int) {
    for (i in list.indices) {
        for (j in 0 until list.size - n - 1) {
            for (h in j until j + n)
                print("${list[i][h]} ")
            print(" || ")
        }
        println()
    }
}

/*
0 0
1 1
2 2
...

1 0
2 1
3 2
..
*/

private fun formatter() {
    val s = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n" +
            "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n" +
            "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n" +
            "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n" +
            "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n" +
            "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n" +
            "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n" +
            "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n" +
            "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n" +
            "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n" +
            "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n" +
            "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n" +
            "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n" +
            "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n" +
            "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n" +
            "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n" +
            "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n" +
            "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n" +
            "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n" +
            "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"
    val a = s.split("\n")
    val list = mutableListOf<List<Int>>()
    a.forEach {
        list.add(
            it.split(" ").map { it.toInt() }
        )
    }
    println('(')
    list.forEach {
        print("listOf(")
        it.forEach {
            print(" $it,")
        }
        print("),")
        println()
    }
    println(')')
}
