class Mission(
    val secretCode: String,
    val meetingPoint: Char,
    val time: Int,
) {
    override fun toString(): String {
        return """
        secret code : $secretCode
        meeting point : $meetingPoint
        time : $time""".trimIndent()
    }
}

fun main() {
    val tokens = readln().split(" ")
    val secretCode = tokens[0]
    val meetingPoint = tokens[1][0]
    val time = tokens[2].toInt()

    println(Mission(secretCode, meetingPoint, time))
}
