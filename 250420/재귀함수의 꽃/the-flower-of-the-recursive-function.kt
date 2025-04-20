fun main() {
    val n = readLine()!!.toInt()
    printNumbers(n)
}

fun printNumbers(n: Int) {
    if (n == 0) return

    print("$n ")
    printNumbers(n - 1)
    print("$n ")
}
