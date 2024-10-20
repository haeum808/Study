package bfs

import java.util.LinkedList
import java.util.Queue

fun main() {
    val visited = BooleanArray(9)
    val graph = Array(9) { ArrayList<Int>() }

    fun bfs(start: Int) {
        val q: Queue<Int> = LinkedList()
        q.offer(start)
        visited[start] = true

        while (q.isNotEmpty()) {
            val x = q.poll()
            print("$x ")

            for (i in 0..<graph[x].size) {
                val y = graph[x][i]

                if (visited[y].not()) {
                    q.offer(y)
                    visited[y] = true
                }
            }
        }
    }

    graph[1].add(2); graph[1].add(3); graph[1].add(8)
    graph[2].add(1); graph[2].add(7)
    graph[3].add(1); graph[3].add(4); graph[3].add(5)
    graph[4].add(3); graph[4].add(5)
    graph[5].add(3); graph[5].add(4)
    graph[6].add(7)
    graph[7].add(2); graph[7].add(6); graph[7].add(8)
    graph[8].add(1); graph[8].add(7)

    bfs(1)
}