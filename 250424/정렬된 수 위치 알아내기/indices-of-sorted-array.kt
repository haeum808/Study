fun main() {
    val n = readLine()!!.trim().toInt()
    val numbers = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    val result = IntArray(n)

    val sortedNumbers = numbers.mapIndexed { index, value -> Pair(value, index) }.sortedBy { it.first }

    for (i in sortedNumbers.indices) {
        result[sortedNumbers[i].second] = i + 1
    }

    println(result.joinToString(" "))
}
