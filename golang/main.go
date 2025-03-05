package main

import (
	// "Study/golang/something"
	"fmt"
)

func main() {
	// something.SayHello()
	// something.sayBye() -> 소문자 시작은 private 취급

	const name string = "haeum"
	// name = "haeum2" -> 상수라 변경 불가능
	fmt.Println(name)
	var name2 string = "haeum"
	name2 = "haeum2"
	fmt.Println(name2)
	name3 := "haeum" // 타입 추론
	name3 = "haeum2"
	fmt.Println(name3)
}
