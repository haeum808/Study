fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    var count = 0

    for (i in a..b) {
        if (isMagicNumber(i)) {
            count++
        }
    }

    println(count)
}

fun isMagicNumber(number: Int): Boolean {
    return number % 3 == 0 || isContain369(number)
}

fun isContain369(number: Int): Boolean {
    return "$number".any { it == '3' || it == '6' || it =='9' }
}
