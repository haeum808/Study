package bronze

import java.math.BigInteger

fun main() {
    val (a, b) = readln().split(" ").map { BigInteger(it) }

    print(a + b)
}