package silver

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    StringTokenizer(readLine()).let { st ->
        val arr = Array(n) { st.nextToken().toInt() }
        arr.sort()
        print(arr[k - 1])
    }
}
