package stack

import java.util.*

fun main() {
    val stack = Stack<Int>()

    stack.push(5)
    stack.push(2)
    stack.push(3)
    stack.push(7)
    stack.pop()
    stack.push(1)
    stack.push(4)
    stack.pop()

    println(stack)
    println(stack.reversed())
}
