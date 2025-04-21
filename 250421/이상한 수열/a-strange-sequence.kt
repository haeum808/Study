fun main() {
    val n = readLine()!!.toInt()
    println(funFactorail(n))
}

fun funFactorail(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 2

    return funFactorail(n / 3) + funFactorail(n - 1)
}
