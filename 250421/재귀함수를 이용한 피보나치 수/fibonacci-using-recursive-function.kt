fun main() {
    val n = readLine()!!.toInt()
    println(fibo(n))
}

fun fibo(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 1

    return fibo(n - 1) + fibo(n - 2)
}
