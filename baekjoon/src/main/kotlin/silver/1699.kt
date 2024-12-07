package silver

import java.util.TreeMap

fun main() {
    val n = readln().toInt()
    val map = TreeMap<String, Int>()
    var count = 0
    var result = ""

    repeat(n) {
        val input = readln()

        map[input] = map.getOrDefault(input, 0) + 1
    }

    map.forEach { (t, u) ->
        if (u > count) {
            count = u
            result = t
        }
    }

    print(result)
}