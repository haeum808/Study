package main

import (
	"Study/golang/something"
	"fmt"
)

func main() {
	fmt.Println("h")
	something.SayHello()
	// something.sayBye() -> 소문자 시작은 private 취
}
