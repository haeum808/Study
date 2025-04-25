class Student(
    val height: Int,
    val weight: Int,
    val order: Int,
): Comparable<Student> {
    override fun compareTo(other: Student): Int {
        if (height == other.height) {
            return other.weight - weight
        }
        return height - other.height
    }

    override fun toString(): String {
        return "$height $weight $order"
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val students = mutableListOf<Triple<Int, Int, Int>>()
    repeat(n) { i ->
        val (height, weight) = readln().split(" ").map { it.toInt() }
        students.add(Triple(height, weight, i + 1))
    }
    students.map { Student(it.first, it.second, it.third) }.sorted().forEach {
        println(it)
    }
}
