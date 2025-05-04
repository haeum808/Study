fun main() {
    val n = readLine()!!.toInt()
    val x1 = IntArray(n)
    val x2 = IntArray(n)
    repeat(n) {
        val (a, b) = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
        x1[it] = a + 100
        x2[it] = b + 100
    }
    val result = IntArray(201)

    repeat(n) {
        for (i in x1[it] until x2[it]) {
            result[i] += 1
        }
    }

    println(result.maxOf { it })
}
