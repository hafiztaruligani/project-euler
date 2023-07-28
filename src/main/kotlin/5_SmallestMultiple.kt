fun main() {
    ans()
}

private fun ans() {
    var n = 2520
    while (true) {
        var found = true
        for (i in 1..20) {
            if (n%i!=0) {
                found = false
                break
            }
        }

        if (found) {
            println(n)
            return
        }
        n++
    }
}
