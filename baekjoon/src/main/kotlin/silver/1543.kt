package silver

fun main() {
    val str = readln()
    val target = readln()
    val replacedStr = str.replace(target, "")

    print((str.length - replacedStr.length) / target.length)
}