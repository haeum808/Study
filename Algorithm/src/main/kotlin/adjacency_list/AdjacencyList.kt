package adjacency_list

fun main() {
    val graph = Array(3) { ArrayList<Pair<Int, Int>>() }

    graph[0].add(1 to 7); graph[0].add(2 to 5)
    graph[1].add(0 to 7)
    graph[2].add(0 to 5)

    println(graph.contentDeepToString())
}