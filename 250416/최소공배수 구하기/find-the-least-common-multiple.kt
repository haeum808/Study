fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(lca(n, m, gcd(n, m)))
}

fun gcd(n: Int, m: Int): Int {
    if (n % m == 0) return m

    return gcd(m, n % m)
}

fun lca(n: Int, m: Int, gcd: Int): Int {
    return n * m / gcd
}
