fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }

    if (b < 11) {
        println(-1)
    } else if (b == 11 && c < 11) {
        println(-1)
    } else {
        val result1 = 11 * 1440 + 11 * 60 + 11
        val result2 = a * 1440 + b * 60 + c
        println(result2 - result1)
    }
}
