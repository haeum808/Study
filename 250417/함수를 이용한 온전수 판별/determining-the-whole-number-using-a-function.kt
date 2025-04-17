fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    var count = 0

    for (i in a..b) {
        if (isOnjeonsu(i)) count++
    }

    println(count)
}

fun isOnjeonsu(number: Int): Boolean {
    return number % 2 != 0  && number % 10 != 5 && !(number % 3 == 0 && number % 9 != 0)
}
