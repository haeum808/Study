fun main() {
    val (nStr, kStr, t) = readLine()!!.split(" ")
    val n = nStr.toInt()
    val k = kStr.toInt()
    val words = List(n) { readLine()!! }

    println(words.filter { it.startsWith(t) }.sorted()[k - 1])
}
