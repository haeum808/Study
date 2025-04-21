fun main() {
    val n = readLine()!!.toInt()
    println(count(n, 0))
}

fun count(n: Int, cnt: Int): Int {
    if (n == 1) return cnt

    if (n % 2 == 0) {
        return count(n / 2, cnt + 1)
    } else {
        return count(n * 3 + 1, cnt + 1)
    }
}
