package silver

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val table = IntArray(2_001)
    val sb = StringBuilder()

    for (number in numbers) {
        table[number + 1000] = 1
    }

    for (index in table.indices) {
        if (table[index] == 1) {
            sb.append("${index - 1000} ")
        }
    }

    print(sb)
}