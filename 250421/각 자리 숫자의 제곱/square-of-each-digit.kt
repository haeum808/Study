fun main() {
    val n = readLine()!!.toInt()
    println(sumPowers(n))
}

fun sumPowers(n: Int): Int {
    if (n < 10) return n * n

    return sumPowers(n / 10) + (n % 10) * (n % 10)
}
