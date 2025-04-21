fun main() {
    val n = readLine()!!.toInt()
    val wordList = List(n) { readLine()!! }

    println(wordList.sorted().joinToString("\n"))
}
