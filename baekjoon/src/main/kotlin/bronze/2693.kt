package bronze

fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val numbers = readln().split(" ").map { it.toInt() }.sortedDescending()

        sb.append("${numbers[2]}\n")
    }

    print(sb)
}