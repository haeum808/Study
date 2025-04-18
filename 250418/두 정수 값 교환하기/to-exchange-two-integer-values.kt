fun main() {
    val (nInput, mInput) = readln().split(" ")
    var n = nInput.toInt()
    var m = mInput.toInt()
    val (newN, newM) = swap(n, m)

    println("$newN $newM")
}

fun swap(a: Int, b: Int): Pair<Int, Int> {
    return Pair(b, a)
}
