package silver

fun main() {
    val sb = StringBuilder()

    while (true) {
        val str = readln()

        if (str == "end") break

        var isAcceptable = false
        var vowelCount = 0
        var notVowelCount = 0
        var preChar = ' '

        for (i in 0..<str.length) {
            if (isAcceptable.not()) {
                if (str[i] in "aeiou") isAcceptable = true
            }

            if (str[i] in "aeiou") {
                vowelCount++
                notVowelCount = 0
            }
            if (str[i] !in "aeiou") {
                notVowelCount++
                vowelCount = 0
            }

            if (vowelCount == 3 || notVowelCount == 3) {
                isAcceptable = false
                break
            }

            if (str[i] != 'e' && str[i] != 'o' && str[i] == preChar) {
                isAcceptable = false
                break
            }

            preChar = str[i]
        }

        if (isAcceptable) {
            sb.append("<${str}> is acceptable.\n")
        } else {
            sb.append("<${str}> is not acceptable.\n")
        }
    }

    print(sb)
}