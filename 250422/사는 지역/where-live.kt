class Person(
    val name: String,
    val addr: String,
    val city: String,
) {
    override fun toString(): String {
        return """
        name $name
        addr $addr
        city $city
        """.trimIndent()
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val people = mutableListOf<Triple<String, String, String>>()
    repeat(n) {
        val (name, address, city) = readln().split(" ")
        people.add(Triple(name, address, city))
    }

    println(people.map { Person(it.first, it.second, it.third) }.sortedBy { it.name }[n - 1])
}