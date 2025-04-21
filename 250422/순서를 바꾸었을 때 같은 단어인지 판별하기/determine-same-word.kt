fun main() {
    val word1 = readLine()!!
    val word2 = readLine()!!

    if (word1.toCharArray().sorted() == word2.toCharArray().sorted()) {
        println("Yes")
    } else {
        println("No")
    }
}