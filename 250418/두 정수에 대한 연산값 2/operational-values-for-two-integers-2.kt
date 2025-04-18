fun main() {
    val (aStr, bStr) = readln().split(" ")
    var a = aStr.toInt()
    var b = bStr.toInt()

    if (a > b) {
        println("${a * 2} ${b + 10}")
    } else {
        println("${a + 10} ${b * 2}")
    }
}
