fun main() {
    val (m1, d1, m2, d2) = readln().split(" ").map { it.toInt() }
    val a = readLine()!!

    val startDayCount = getDayCountUntil(m1, d1)
    val endDayCount = getDayCountUntil(m2, d2)
    val targetDayOffset = findWeek(a)

    val result = (endDayCount - startDayCount + targetDayOffset) / 7

    println(result)
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
        else -> throw Exception("Invalid day")
    }
}

fun getDayCountUntil(month: Int, day: Int): Int {
    val daysInMonth = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    return daysInMonth.take(month - 1).sum() + day
}
