fun main() {
    val (aInput, bInput) = readln().split(" ")
    var a = aInput.toInt()
    var b = bInput.toInt()

    if (a > b) {
        println("${a + 25} ${b * 2}")
    } else {
        println("${a * 2} ${b + 25}")
    }
}
