package bronze

fun main() {
    val (x, y) = readln().split(" ")

    print((x.reversed().toInt() + y.reversed().toInt()).toString().reversed().toInt())
}