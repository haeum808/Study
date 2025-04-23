fun main() {
    val n = readLine()!!.toInt()
    val students = mutableListOf<Student>()
    repeat(n) {
        val input = readln().split(" ")
        val name = input[0]
        val korean = input[1].toInt()
        val english = input[2].toInt()
        val math = input[3].toInt()
        students.add(Student(name, korean, english, math))
    }

    students.sorted().forEach { 
        println(it)
    }
}

data class Student(val name: String, val korean: Int, val english: Int, val math: Int): Comparable<Student> {
    override fun compareTo(other: Student): Int {
        if (this.korean == other.korean) {
            if (this.english == other.english) {
                return other.math - this.math
            } else {
                return other.english - this.english
            }
        } else {
            return other.korean - this.korean
        }
    }

    override fun toString(): String {
        return "$name $korean $english $math"
    }
}
