fun main() {
    val n = readLine()!!.toInt()
    println(funFactorial(n))
}

fun funFactorial(n: Int): Int {
    if (n == 1) return 2
    if (n == 2) return 4

    return funFactorial(n - 1) * funFactorial(n - 2) % 100
}
