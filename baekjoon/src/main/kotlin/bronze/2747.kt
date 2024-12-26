package bronze

fun main() {
    val n = readln().toInt()
    val fibonacci = IntArray(n + 1)

    when(n) {
        0 -> print(0)
        1 -> print(1)
        else -> {
            fibonacci[0] = 0
            fibonacci[1] = 1

            for (i in 2..n) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]
            }

            print(fibonacci[n])
        }
    }
}