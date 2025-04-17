fun main() {
    val (m, d) = readln().split(" ").map { it.toInt() }

    if (isValidDate(m, d)) {
        println("Yes")
    } else {
        println("No")
    }
}

fun isValidDate(m: Int, d: Int): Boolean {
    return when {
        m in listOf(1, 3, 5, 7, 8, 10, 12) && d in 1..31 -> true
        m == 2 && d in 1..28 -> true
        m in listOf(4, 6, 9, 11) && d in 1..30 -> true
        else -> false
    }
}
