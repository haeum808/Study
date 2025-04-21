fun main() {
    val n = readLine()!!.toInt()
    println(count(n, 0))
}

fun count(n: Int, count: Int): Int {
    if (n == 1) return count

    if (n % 2 == 0) {
        return count(n / 2, count + 1)
    } else {
        return count(n / 3, count + 1)
    }
}
