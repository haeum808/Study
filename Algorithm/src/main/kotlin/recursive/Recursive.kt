package recursive

fun main() {
    recursiveFunction(1)
}

fun recursiveFunction(i: Int) {
    if (i == 100) {
        return
    }

    println("${i}번째 재귀 함수에서 ${i + 1}번째 재귀 함수를 호출합니다.")
    recursiveFunction(i + 1)
    println("${i}번째 재귀 함수를 종료합니다.")
}