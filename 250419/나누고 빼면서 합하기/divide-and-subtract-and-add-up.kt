fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = listOf(0) + readLine()!!.split(" ").map { it.toInt() }
    var cnt = m
    var result = arr[1]

    while(cnt != 1) {
        result += arr[cnt]
        if (cnt % 2 == 0) {
            cnt = cnt / 2
        } else {
            cnt = cnt - 1
        }
    }

    println(result)
}