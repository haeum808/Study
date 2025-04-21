fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }

    println(lca(numbers, 0, numbers[0]))
}

fun lca(arr: List<Int>, index: Int, lca: Int): Int {
    if (index == arr.size - 1) return lca

    return lca(arr, index + 1, lca * arr[index + 1] / gcd(lca, arr[index + 1]))
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}
