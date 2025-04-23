import kotlin.math.abs

class Point(
    val x: Int,
    val y: Int,
    val order: Int,
)

fun main() {
    val n = readLine()!!.toInt()
    val points = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        points.add(Pair(x, y))
    }

    points.mapIndexed { index, point ->
        Point(point.first, point.second, index + 1)
    }.sortedBy {
        abs(it.x) + abs(it.y)
    }.forEach {
        println(it.order)
    }
}
