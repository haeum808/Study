fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = listOf(0) + readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    val queries = List(m) {
        val (a1, a2) = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
        a1 to a2
    }

    repeat(m) {
        var result = 0
        val (start, end) = queries[it]
        for (i in start..end) {
            result += arr[i]
        }
        println(result)
    }
}
