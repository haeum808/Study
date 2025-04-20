fun main() {
    val n = readLine()!!.toInt()

    printStars(n)
}

fun printStars(n: Int) {
    if (n == 0) return

    for (i in 1..n) {
        print("* ")
    }
    println()
    printStars(n - 1)
    for (i in 1..n) {
        print("* ")
    }
    println()
}
