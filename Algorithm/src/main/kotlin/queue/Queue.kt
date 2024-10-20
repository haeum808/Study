package queue

import java.util.LinkedList
import java.util.Queue

fun main() {
    val queue: Queue<Int> = LinkedList()

    queue.offer(5)
    queue.offer(2)
    queue.offer(3)
    queue.offer(7)
    queue.poll()
    queue.offer(1)
    queue.offer(4)
    queue.poll()

    println(queue)
    println(queue.reversed())
}