fun main() {
    val n = readLine()!!.toInt()

    printAsc(n)
    println()
    printDesc(n)
}

fun printAsc(n: Int) {
    if (n == 0) return

    printAsc(n - 1)
    print("$n ")
}

fun printDesc(n: Int) {
    if (n == 0) return

    print("$n ")
    printDesc(n - 1)
}
