package bronze

fun main() {
    val l = readln().toInt()
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()

    var A = a / c
    var B = b / d

    if (a % c != 0) {
        A += 1
    }
    if (b % d != 0) {
        B += 1
    }

    val result = l - maxOf(A, B)

    print(result)
}
