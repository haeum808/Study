fun main() {
    val n = readLine()!!.toInt()
    printHelloWorld(n)
}

fun printHelloWorld(n: Int) {
    if (n == 0) return

    printHelloWorld(n - 1)
    println("HelloWorld")
}
