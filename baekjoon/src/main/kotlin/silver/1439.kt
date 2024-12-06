package silver

fun main() {
    val s = readln()
    var zeroCount = 0
    var oneCount = 0
    var current = ' '

    for (char in s) {
        if (char == '0' && current != char) {
            current = char
            zeroCount++
        } else if (char == '1' && current != char) {
            current = char
            oneCount++
        }
    }

    if (zeroCount == 0 || oneCount == 0) {
        print(0)
    } else {
        print(minOf(zeroCount, oneCount))
    }
}
