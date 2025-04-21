fun main() {
    val (n, k) = readLine()!!.split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    val nums = readLine()!!.split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    println(nums.sorted()[k - 1])
}
