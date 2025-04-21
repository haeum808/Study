fun main() {
    val n = readLine()!!.toInt()
    println(printSum(n))
}

fun printSum(n: Int): Int {
    if (n == 1 || n == 2) return n

    return printSum(n - 2) + n
}
