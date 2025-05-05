fun main() {
    val n = readLine()!!.toInt()
    val commands = mutableListOf<Pair<Int, Char>>()
    repeat(n) {
        val parts = readln().split(" ")
        val x = parts[0].toInt()
        val c = parts[1][0]
        commands.add(x to c)
    }
    val result = IntArray(200_001)
    var current = 100_000
    var w = 0
    var b = 0

    repeat(n) {
        val (x, c) = commands[it]

        if (c == 'L') {
            for (i in current - x + 1 .. current) {
                result[i] = 1
            }
            current += -x + 1
        } else {
            for (i in current .. current + x - 1) {
                result[i] = 2
            }
            current += x - 1
        }
    }

    for (i in 0..200_000) {
        if (result[i] == 1) w++
        else if (result[i] == 2) b++
    }

    println("$w $b")
}
