fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val b = readLine()!!.split(" ").map { it.toInt() }.sorted()

    if (a == b) {
        println("Yes")
    } else {
        println("No")
    }
}
