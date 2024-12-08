package silver

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val queue: Queue<Int> = LinkedList()
    val sb = StringBuilder()

    for (number in 1..n) {
        queue.offer(number)
    }

    while (queue.isNotEmpty()) {
        sb.append("${queue.poll()} ")

        if (queue.isEmpty()) break

        queue.offer(queue.poll())
    }

    print(sb)
}