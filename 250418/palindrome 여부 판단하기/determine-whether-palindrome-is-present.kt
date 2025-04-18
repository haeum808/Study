fun main() {
    val str = readLine()!!

    if (isPalindrome(str)) {
        println("Yes")
    } else {
        println("No")
    }
}

fun isPalindrome(str: String): Boolean {
    for (i in 0 until str.length / 2) {
        if (str[i] != str[str.length - i - 1]) return false
    }

    return true
}
