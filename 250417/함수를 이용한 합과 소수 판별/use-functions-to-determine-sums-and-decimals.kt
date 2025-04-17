fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    var count = 0

    for (i in a..b) {
        if (isMagicNumber(i)) count++
    }

    println(count)
}

fun isMagicNumber(number: Int): Boolean {
    return isPrime(number) && isDigitSumEven(number)
}

fun isPrime(number: Int): Boolean {
    if (number == 1) return false

    for (i in 2 until number) {
        if (number % i == 0) return false
    }

    return true
}

fun isDigitSumEven(number: Int): Boolean {
    return "$number".sumOf { it.digitToInt() } % 2 == 0
}
