fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(findMin(a, b, c))
}

fun findMin(a: Int, b: Int, c: Int): Int {
    return minOf(a, b, c)
}
