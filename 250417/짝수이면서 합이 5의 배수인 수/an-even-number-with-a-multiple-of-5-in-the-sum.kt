fun main() {
    val n = readLine()!!.toInt()

    if (isMagicNumber(n)) {
        println("Yes")
    } else {
        println("No")
    }
}

fun isMagicNumber(num: Int): Boolean {
    return num % 2 == 0 && ((num / 10) + (num % 10)) % 5 == 0
}
