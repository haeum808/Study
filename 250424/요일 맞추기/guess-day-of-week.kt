fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val m1 = input[0]
    val d1 = input[1]
    val m2 = input[2]
    val d2 = input[3]

    var result1 = d1
    var result2 = d2

    for (i in 1..m1) {
        result1 += calculate(i)
    }
    for (i in 1..m2) {
        result2 += calculate(i)
    }

    println(findWeek((result2 - result1) % 7))
}

fun findWeek(number: Int): String {
    return when(number) {
        -1, 6 -> "Sun"
        0 -> "Mon"
        -6, 1 -> "Tue"
        -5, 2 -> "Wed"
        -4, 3 -> "Thu"
        -3, 4 -> "Fri"
        -2, 5 -> "Sat"
        else -> throw Exception()
    }
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
