class User(
    val id: String = "codetree",
    val level: Int = 10,
) {
    override fun toString(): String {
        return "user $id lv $level"
    }
}

fun main() {
    val (id2, level2String) = readln().split(" ")
    val level2 = level2String.toInt()

    println(User())
    println(User(id2, level2))    
}
