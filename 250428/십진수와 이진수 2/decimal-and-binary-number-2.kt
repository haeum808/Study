fun main() {
    val binary = readLine()!!
    var decimal = 0

    for (i in binary.indices) {
        decimal = decimal * 2 + binary[i].digitToInt()
    }
    decimal *= 17

    var result = ""

    while(true) {
        if (decimal < 2) {
            result += "${decimal % 2}"
            break
        }

        result += "${decimal % 2}"
        decimal /= 2
    }

    println(result.reversed())
}
