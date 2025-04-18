fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    for (i in arr.indices) {
        if (arr[i] % 2 == 0) {
            arr[i] /= 2
        }
    }

    println(arr.joinToString(" "))
}
