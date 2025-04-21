fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toInt() }
    println(nums.sorted()[k - 1])
}
