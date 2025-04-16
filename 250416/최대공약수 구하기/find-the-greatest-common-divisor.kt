fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(gcd(n, m))
}

fun gcd(n: Int, m: Int): Int {
    if (n % m == 0) return m

    return gcd(m, n % m)
}
