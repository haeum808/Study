fun main() {
    var n = readln().toInt()
    var result = ""

    while (true) {
        if (n < 2) {
            result += "${n % 2}"
            break
        }

        result += "${n % 2}"
        n /= 2
    }
    
    println(result.reversed())
}
