data class Student(val name: String, val height: Int, val weight: Double) {
    override fun toString(): String {
        return "$name $height $weight"
    }
}

fun main() {
    val students = mutableListOf<Student>()
    repeat(5) {
        val (name, heightStr, weightStr) = readln().split(" ")
        val height = heightStr.toInt()
        val weight = weightStr.toDouble()
        students.add(Student(name, height, weight))
    }

    println("name")
    students.sortedBy { it.name }.forEach { println(it) }
    println()
    println("height")
    students.sortedBy { -it.height }.forEach { println(it) }
}
