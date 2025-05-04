fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = IntArray(k)
    val b = IntArray(k)
    for (i in 0 until k) {
        val values = readln().split(" ").map { it.toInt() }
        a[i] = values[0]
        b[i] = values[1]
    }
    val result = IntArray(n + 1)

    for (i in 0 until k) {
        for (j in a[i]..b[i]) {
            result[j] += 1
        }
    }

    println(result.maxOf { it })
}
