import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    
    println(numbers.map { abs(it) }.joinToString(" "))
}
