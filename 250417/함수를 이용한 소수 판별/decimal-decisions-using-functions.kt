fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val a = input[0]
    val b = input[1]
    var total = 0

    for (i in a..b) {
        if (isPrime(i)) total += i
    }

    println(total)
}

fun isPrime(number: Int): Boolean {
    if (number == 1) return false

    for (i in 2 until number) {
        if (number % i == 0) return false
    }

    return true
}
