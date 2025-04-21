fun main() {
    val n = readLine()!!.toInt() * 2
    val nums = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }.sorted()
    var result = 0

    for (i in 0 until n / 2) {
        result = maxOf(result, nums[i] + nums[n - i - 1])
    }

    println(result)
}
