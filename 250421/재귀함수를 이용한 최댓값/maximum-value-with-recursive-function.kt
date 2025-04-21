fun main() {
    val n = readLine()!!.toInt()
    val arr = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }

    println(findMax(arr, 0))
}

fun findMax(arr : List<Int>, max: Int): Int {
    if (arr.size == 0) return max

    return findMax(arr.slice(1 until arr.size), maxOf(max, arr[0]))
}
