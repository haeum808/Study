fun countDayOccurrences(m1: Int, d1: Int, m2: Int, d2: Int, targetDayStr: String): Int {
    val dayOfWeekMap = mapOf(
        "Mon" to 0,
        "Tue" to 1,
        "Wed" to 2,
        "Thu" to 3,
        "Fri" to 4,
        "Sat" to 5,
        "Sun" to 6
    )
    val targetDay = dayOfWeekMap[targetDayStr] ?: error("유효하지 않은 요일")
    val daysInMonth = arrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    var totalDays = 0
    if (m1 == m2) {
        totalDays = d2 - d1
    } else {
        totalDays += daysInMonth[m1] - d1
        for (m in (m1 + 1) until m2) {
            totalDays += daysInMonth[m]
        }
        totalDays += d2
    }

    var count = 0
    for (i in 0..totalDays) {
        val currentDay = (i % 7)
        if (currentDay == targetDay) {
            count++
        }
    }
    return count
}

fun main() {
    val (m1, d1, m2, d2) = readln().split(" ").map { it.toInt() }
    val a = readln()

    val result = countDayOccurrences(m1, d1, m2, d2, a)
    println(result)
}
