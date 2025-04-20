fun main() {
    val n = readLine()!!.toInt()
    printStars(n)
}

fun printStars(n: Int) {
    if (n == 0) return

    printStars(n - 1)
    for (i in 1..n) {
        print("*")
    }
    println()
}
