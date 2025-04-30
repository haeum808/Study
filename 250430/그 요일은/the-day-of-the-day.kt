fun main() {
    val (m1, d1, m2, d2) = readln().split(" ").map { it.toInt() }
    val a = readln()
    var result1 = calculateDayCount(m1, d1) 
    var result2 = calculateDayCount(m2, d2) + findWeek(a)

    println((result2 - result1) / 7)
}

fun findWeek(week: String): Int {
    return when(week) {
        "Mon" -> 0
        "Tue" -> 1
        "Wed" -> 2
        "Thu" -> 3
        "Fri" -> 4
        "Sat" -> 5
        "Sun" -> 6
        else -> throw Exception()
    }
}

fun calculateDayCount(month: Int, day: Int): Int {
    val daysInMonth = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    return daysInMonth.take(month - 1).sum() + day
}
