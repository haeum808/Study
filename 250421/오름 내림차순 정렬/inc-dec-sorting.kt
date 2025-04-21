fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").filter { it.isNotBlank() }.map { it.toInt() }

    println(nums.sorted().joinToString(" "))
    println(nums.sortedDescending().joinToString(" "))
}
