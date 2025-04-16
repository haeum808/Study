fun main() {
    val n = readLine()!!.toInt()
    println(addAll(n))
}

fun addAll(n: Int): Int {
    return (1..n).reduce { total, num -> total + num } / 10
}
