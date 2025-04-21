fun main() {
    val n = readLine()!!.toInt()
    val arr = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }

    println(findMax(arr, 0, 0))
}

fun findMax(arr: List<Int>, index: Int, currentMax: Int): Int {
    if (index == arr.size) return currentMax
    return findMax(arr, index + 1, maxOf(currentMax, arr[index]))
}
