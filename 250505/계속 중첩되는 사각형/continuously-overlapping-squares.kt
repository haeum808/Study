fun main() {
    val n = readLine()!!.toInt()
    val x1 = IntArray(n)
    val y1 = IntArray(n)
    val x2 = IntArray(n)
    val y2 = IntArray(n)
    for (i in 0 until n) {
        val inputs = readln().split(" ").map { it.toInt() }
        x1[i] = inputs[0] + 100
        y1[i] = inputs[1] + 100
        x2[i] = inputs[2] + 100
        y2[i] = inputs[3] + 100
    }
    val result = Array(201) { IntArray(201) }
    var add = 0

    repeat(n) {
        if (add == 0) {
            for (i in x1[it] until x2[it]) {
                for (j in y1[it] until y2[it]) {
                    result[i][j] = 0
                }
            }
            add = 1
        } else {
            for (i in x1[it] until x2[it]) {
                for (j in y1[it] until y2[it]) {
                    result[i][j] = 1
                }
            }
            add = 0
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