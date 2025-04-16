fun main() {
    val n = readLine()!!.toInt()
    drawRect(n)
}

fun drawRect(n: Int) {
    var count = 1

    for (i in 1..n) {
        for (j in 1..n) {
            print("${count++} ")
            if (count == 10) count = 1
        }
        println()
    }
}