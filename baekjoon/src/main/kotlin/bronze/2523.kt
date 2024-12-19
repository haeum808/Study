package bronze

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    for (i in 1..n) {
        repeat(i) {
            sb.append("*")
        }
        sb.append("\n")
    }

    for (i in n - 1 downTo 1) {
        repeat(i) {
            sb.append("*")
        }
        sb.append("\n")
    }

    print(sb)
}