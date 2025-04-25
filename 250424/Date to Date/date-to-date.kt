fun main() {
    val (m1, d1, m2, d2) = readLine()!!.split(" ").map { it.toInt() }
    var result1 = d1
    var result2 = d2

    for (i in 1..m1) {
        result1 += calculate(i)
    }
    for (i in 1..m2) {
        result2 += calculate(i)
    }

    println(result2 - result1 + 1)
}

fun calculate(month: Int): Int {
    return when (month - 1) {
        0 -> 0
        1, 3, 5, 7, 8, 10, 12 -> 31
        2 -> 28
        4, 6, 9, 11 -> 30
        else -> throw Exception()
    }
}
