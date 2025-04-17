fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(power(a, b))
}

fun power(target: Int, exponent: Int): Int {
    var result = 1

    repeat(exponent) {
        result *= target
    }

    return result
}
