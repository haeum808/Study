fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }

    println(nums.sorted().joinToString(" "))
    println(nums.sortedDescending().joinToString(" "))
}
