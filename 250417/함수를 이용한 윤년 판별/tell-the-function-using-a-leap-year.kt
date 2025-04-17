fun main() {
    val y = readLine()!!.toInt()

    println(isLeapYear(y))
}

fun isLeapYear(year: Int): Boolean {
    return !(year % 100 == 0 && year % 400 != 0) && year % 4 == 0
}
