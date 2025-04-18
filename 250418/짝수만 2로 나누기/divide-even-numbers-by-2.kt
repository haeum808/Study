fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").filter { it.isNotBlank() }.map { it.toInt() }.toMutableList()

    for (i in arr.indices) {
        if (arr[i] % 2 == 0) {
            arr[i] /= 2
        }
    }

    println(arr.joinToString(" "))
}
