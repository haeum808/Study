data class Student(val height: Int, val weight: Int, val number: Int): Comparable<Student> {
    override fun compareTo(other: Student): Int {
        if (height == other.height) {
            if (weight == other.weight) {
                return number - other.number
            } else {
                return other.weight - weight
            }
        } else {
            return other.height - height
        }
    }

    override fun toString(): String {
        return "$height $weight $number"
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val students = mutableListOf<Student>()
    repeat(n) { i ->
        val (height, weight) = readln().split(" ").map { it.toInt() }
        students.add(Student(height, weight, i + 1))
    }
    students.sorted().forEach {
        println(it)
    }
}
