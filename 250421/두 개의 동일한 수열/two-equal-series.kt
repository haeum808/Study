fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").filter { it.isNotBlank() }.map { it.toInt() }.sorted()
    val b = readLine()!!.split(" ").filter { it.isNotBlank() }.map { it.toInt() }.sorted()

    if (a == b) {
        println("Yes")
    } else {
        println("No")
    }
}
