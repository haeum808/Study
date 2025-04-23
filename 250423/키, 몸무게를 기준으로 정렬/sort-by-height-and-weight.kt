data class Student(val name: String, val height: Int, val weight: Int): Comparable<Student> {
    override fun compareTo(other: Student): Int {
        if (height == other.height) {
            return other.weight - weight
        }
        return height - other.height
    }

    override fun toString(): String {
        return "$name $height $weight"
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val students = mutableListOf<Student>()
    repeat(n) {
        val tokens = readln().split(" ")
        val name = tokens[0]
        val height = tokens[1].toInt()
        val weight = tokens[2].toInt()
        students.add(Student(name, height, weight))
    }

    students.sorted().forEach {
        println(it)
    }    
}