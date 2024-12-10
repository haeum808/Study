package silver

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }
    var count = 0

    if (n == 1) {
        if (numbers[0] == m) count = 1
    } else {
        var i = 0
        var j = 1
        var sum = numbers[0]

        while (true) {
            if (sum == m) {
                sum -= numbers[i++]
                count++
            } else if (sum < m) {
                if (j == n) break
                sum += numbers[j++]
            } else {
                sum -= numbers[i++]
            }
        }
    }
    print(count)
}