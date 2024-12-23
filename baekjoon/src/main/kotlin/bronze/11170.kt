package bronze

fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        var count = 0

        for (number in n..m) {
            count += number.toString().count { it == '0' }
        }

        sb.append("$count\n")
    }

    print(sb)
}