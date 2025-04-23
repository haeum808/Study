fun main() {
    val n = readLine()!!.toInt()
    val students = mutableListOf<Student>()
    repeat(n) {
        val (name, korean, english, math) = readln().split(" ")
        students.add(Student(name, korean.toInt(), english.toInt(), math.toInt()))
    }
    students.sorted().forEach {
        println(it)
    }
}

data class Student(val name: String, val korean: Int, val english: Int, val math: Int): Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return (this.korean + this.english + this.math) - (other.korean + other.english + other.math)
    }

    override fun toString(): String {
        return "$name $korean $english $math"
    }
}
