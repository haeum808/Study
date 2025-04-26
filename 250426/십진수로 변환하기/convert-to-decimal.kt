fun main() {
    val binary = readLine()!!
    var result = 0

    for (i in binary.indices) {
        result = result * 2 + binary[i].digitToInt()
    }

    println(result)
}
