fun main() {
    val n = readLine()!!.toInt()
    val x1 = IntArray(n)
    val y1 = IntArray(n)
    val x2 = IntArray(n)
    val y2 = IntArray(n)
    repeat(n) { i ->
        val (a, b, c, d) = readln().split(" ").map { it.toInt() }
        x1[i] = a + 100
        y1[i] = b + 100
        x2[i] = c + 100
        y2[i] = d + 100
    }
    val result = Array(201) { IntArray(201) }

    repeat(n) {
        for (i in x1[it] until x2[it]) {
            for (j in y1[it] until y2[it]) {
                result[i][j] = 1
            }
        }
    }

    var count = 0

    for (i in 0..200) {
        for (j in 0..200) {
            if (result[i][j] == 1) count++
        }
    }

    println(count)
}