class Person(
    val name: String,
    val height: Int,
    val weight: Int,
) {
    override fun toString(): String {
        return "$name $height $weight"
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val students = mutableListOf<Triple<String, Int, Int>>()
    repeat(n) {
        val (name, heightStr, weightStr) = readln().split(" ")
        val height = heightStr.toInt()
        val weight = weightStr.toInt()
        students.add(Triple(name, height, weight))
    }

    students.map { Person(it.first, it.second, it.third) }.sortedBy { it.height }.forEach { println(it) }
}
