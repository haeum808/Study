fun main() {
    val (n1, n2) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }
    val b = readLine()!!.split(" ").map { it.toInt() }

    if (isContinuousSubsequence(a, b)) {
        println("Yes")
    } else {
        println("No")
    }
}

fun isContinuousSubsequence(a: List<Int>, b: List<Int>): Boolean {
    if (a.size < b.size) return false

    for (i in 0..(a.size - b.size)) {
        if (a.slice(i until i + b.size) == b) return true
    }

    return false
}
