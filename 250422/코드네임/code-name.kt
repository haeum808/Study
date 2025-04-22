class User(
    val id: Char,
    val score: Int,
)

fun main() {
    val users = mutableListOf<Pair<Char, Int>>()
    repeat(5) {
        val (code, scoreStr) = readln().split(" ")
        users.add(code[0] to scoreStr.toInt())
    }

    val agents = users.map { User(it.first, it.second) }
    var id = 'A'
    var score = 101

    for (agent in agents) {
        if (agent.score < score) {
            id = agent.id
            score = agent.score
        }
    }

    println("$id $score")
}
