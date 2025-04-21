fun main() {
    val n = readLine()!!.toInt() * 2
    val nums = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }.sorted()

    println(nums[n / 2 - 1] + nums[n / 2])
}
