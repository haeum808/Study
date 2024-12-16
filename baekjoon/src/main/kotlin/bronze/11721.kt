package bronze

fun main() {
    val str = readln()

    str.chunked(10).forEach {
        println(it)
    }
}