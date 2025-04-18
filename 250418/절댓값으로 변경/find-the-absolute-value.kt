import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readln().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    
    println(numbers.map { abs(it) }.joinToString(" "))
}
