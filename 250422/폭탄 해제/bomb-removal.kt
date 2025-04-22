class Bomb(
    val code: String,
    val color: Char,
    val second: Int,
) {
    override fun toString(): String {
        return """
        code : $code
        color : $color
        second : $second""".trimIndent()
    }
}

fun main() {
    val input = readln().split(" ")
    val unlockCode = input[0]
    val linearColor = input[1][0]
    val time = input[2].toInt()

    println(Bomb(unlockCode, linearColor, time))
}
