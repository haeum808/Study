fun main() {
    val (aX1, aY1, aX2, aY2) = readln().split(" ").map { it.toInt() + 1000 }
    val (bX1, bY1, bX2, bY2) = readln().split(" ").map { it.toInt() + 1000 }
    val (mX1, mY1, mX2, mY2) = readln().split(" ").map { it.toInt() + 1000 }

    val result = Array(2001) { IntArray(2001) }

    for (i in aX1 until aX2) {
        for (j in aY1 until aY2) {
            result[i][j] = 1
        }
    }

    for (i in bX1 until bX2) {
        for (j in bY1 until bY2) {
            result[i][j] = 1
        }
    }

    for (i in mX1 until mX2) {
        for (j in mY1 until mY2) {
            result[i][j] = 0
        }
    }

    var total = 0

    for (i in 0..2000) {
        for (j in 0..2000) {
            if (result[i][j] == 1) total++
        }
    }

    println(total)
}