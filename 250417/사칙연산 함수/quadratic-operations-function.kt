fun main() {
    val tokens = readln().split(" ")
    val a = tokens[0].toInt()
    val op = tokens[1].single()
    val c = tokens[2].toInt()

    println(fourBasicOperations(a, op, c))
}

fun fourBasicOperations(a: Int, op: Char, c: Int): String {
    return when(op) {
        '+' -> "$a + $c = ${a + c}"
        '-' -> "$a - $c = ${a - c}"
        '*' -> "$a * $c = ${a * c}"
        '/' -> "$a / $c = ${a / c}"
        else -> "False"
    }
}
