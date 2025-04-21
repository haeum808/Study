fun main() {
    val n = readLine()!!.toInt()
    println(sumNumbers(n))
}

fun sumNumbers(n: Int): Int {
    if (n == 1) return 1

    return sumNumbers(n - 1) + n
}
