fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val n = readLine()!!
    var decimal = 0
    var result = ""

    for (index in n.indices) {
        decimal = decimal * a + n[index].digitToInt()
    }

    while(true) {
        if (decimal < b) {
            result += "${decimal % b}"
            break
        }
        result += "${decimal % b}"
        decimal = decimal / b
    }

    println(result.reversed())
}
