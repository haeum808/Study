package adjacency_martix

fun main() {
    val inf = Int.MAX_VALUE
    val graph = arrayOf(
        intArrayOf(0, 7, 5),
        intArrayOf(7, 0, inf),
        intArrayOf(5, inf, 0),
    )

     println(graph.contentDeepToString())
}