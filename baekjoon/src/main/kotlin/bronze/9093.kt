package bronze

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val input = readln()

        sb.append("${input.split(" ").joinToString(" ") { it.reversed() }}\n")
    }

    print(sb)
}