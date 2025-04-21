fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(sumOfBigNumber(a * b * c))
}

fun sumOfBigNumber(n: Int): Int {
    if (n < 10) return n

    return sumOfBigNumber(n / 10) + n % 10
}
