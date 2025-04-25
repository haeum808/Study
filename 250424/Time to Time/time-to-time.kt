fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }

    println((c * 60 + d) - (a * 60 + b))
}
