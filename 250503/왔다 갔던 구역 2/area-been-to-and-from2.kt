fun main() {
    val n = readLine()!!.toInt()
    val commands = MutableList(n) {
        val (distanceStr, directionStr) = readln().split(" ")
        Pair(distanceStr.toInt(), directionStr[0])
    }
    val result = IntArray(4001)
    var current = 2000

    repeat(n) {
        val command = commands[it]

        if (command.second == 'L') {
            for (i in current - command.first until current) {
                result[i] += 1
            }
            current = current - command.first
        } else {
            for (i in current until command.first + current) {
                result[i] += 1
            }
            current = current + command.first
        }
    }

    println(result.count { it >= 2 })
}