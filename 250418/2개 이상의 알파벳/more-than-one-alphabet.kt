fun main() {
    val a: String = readLine()!!

    if (a.toSet().size >= 2) {
        println("Yes")
    } else {
        println("No")
    }
}
