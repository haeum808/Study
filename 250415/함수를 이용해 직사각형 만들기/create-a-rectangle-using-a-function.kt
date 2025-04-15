fun main() {
    val (rowNum, colNum) = readln().split(" ").map { it.toInt() }
    printRect(rowNum, colNum)
}

fun printRect(h: Int, w: Int) {
    repeat(h) {
        repeat(w) {
            print("1")
        }
        println()
    }
}
