fun main() {
    val input = readln().split(" ")
    var n = input[0].toInt()
    val b = input[1].toInt()
    var result = ""

    while (true) {
        if (n < b) {
            result += "${n % b}"
            break
        }

        result += "${n % b}"
        n /= b
    }

    println(result.reversed())
}
