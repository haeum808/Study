fun main() {
    val (y, m, d) = readln().split(" ").map { it.toInt() }

    println(getSeasonName(y, m, d))
}

fun getSeasonName(y: Int, m: Int, d: Int): String {
    if (!isValidDate(y, m, d)) return "-1"

    return when (m) {
        in listOf(3, 4, 5) -> "Spring"
        in listOf(6, 7, 8) -> "Summer"
        in listOf(9, 10, 11) -> "Fall"
        in listOf(12, 1, 2) -> "Winter"
        else -> "Error"
    }
}

fun isValidDate(y: Int, m: Int, d: Int): Boolean {
    return when {
        m in listOf(1, 3, 5, 7, 8, 10, 12) && d in 1..31 -> true
        m in listOf(4, 6, 9, 11) && d in 1..30 -> true
        m == 2 && isLeapYear(y) && d in 1..29 -> true
        m == 2 && !isLeapYear(y) && d in 1..28 -> true
        else -> false
    }
}

fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}
