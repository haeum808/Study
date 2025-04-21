fun main() {
    val n = readLine()!!.toInt()
    val numbers = readln().split(" ").map { it.toInt() }

    for (i in 0 until n) {
        if (i % 2 == 0) {
            print("${numbers.slice(0..i).sorted()[i / 2]} ")
        }
    }
}
