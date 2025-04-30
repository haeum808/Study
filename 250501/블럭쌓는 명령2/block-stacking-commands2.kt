fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = IntArray(n)
    val b = IntArray(n)
    for (i in 0 until k) {
        val values = readln().split(" ").map { it.toInt() }
        a[i] = values[0] - 1
        b[i] = values[1] - 1
    }
    var result = 0

    for (i in 0 until k) {
        result = maxOf(result, b[i] - a[i] + 1) 
    }

    println(result)
}
