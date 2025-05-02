fun main() {
    val n = readLine()!!.toInt()
    val segments = MutableList(n) {
        val (x1, x2) = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
        Pair(x1, x2)
    }
    val result = IntArray(101)

    repeat(n) {
        for (i in segments[it].first..segments[it].second) {
            result[i] += 1
        }
    }

    println(result.maxOf { it })
}