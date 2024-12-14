package bronze

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    for (i in 1..n) {
        repeat(n - i) {
            sb.append(" ")
        }
        repeat(i) {
            sb.append("*")
        }
        sb.append("\n")
    }

    for (i in 1..n) {
        repeat(i) {
            sb.append(" ")
        }
        repeat(n - i) {
            sb.append("*")
        }
        sb.append("\n")
    }

    print(sb)
}