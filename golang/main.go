package main

import (
	"Study/golang/something"
	"fmt"
	"strings"
)

func multiply(a int, b int) int {
	return a * b
}

func multiply2(a, b int) int {
	return a * b
}

func lenAndUpper(name string) (int, string) {
	return len(name), strings.ToUpper(name)
}

func repeatMe(words ...string) {
	fmt.Println(words)
}

func main() {
	something.SayHello()
	// something.sayBye() -> 소문자 시작은 private 취급

	const name string = "haeum"
	// name = "haeum2" -> 상수라 변경 불가능
	fmt.Println(name)
	var name2 string = "haeum"
	name2 = "haeum2"
	fmt.Println(name2)
	name3 := "haeum" // 타입 추론, 뱐수만 가능, 함수 내에서만 가능
	name3 = "haeum2"
	fmt.Println(name3)

	fmt.Println(multiply(2, 2))
	fmt.Println(multiply2(2, 2))

	totalLength, upperName := lenAndUpper("haeum")
	fmt.Println(totalLength, upperName)
	totalLength2, _ := lenAndUpper("haeum")
	fmt.Println(totalLength2)

	repeatMe("haeum", "haeum1", "haeum2", "haeum3", "haeum4")
}
