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

func lenAndUpper2(name string) (length int, uppercase string) {
	defer fmt.Println("I'm done")
	length = len(name)
	uppercase = strings.ToUpper(name)
	return
}

func superAdd(numbers ...int) int {
	for index, number := range numbers {
		fmt.Println(index, number)
	}
	for i := 0; i < len(numbers); i++ {
		fmt.Println(numbers[i])
	}
	total := 0
	for _, number := range numbers {
		total += number
	}
	return total
}

func repeatMe(words ...string) {
	fmt.Println(words)
}

func canIDrink(age int) bool {
	if koreanAge := age + 2; koreanAge < 18 {
		return false
	}
	return true
}

func canIDrink2(age int) bool {
	switch koreanAge := age + 2; koreanAge {
	case 10:
		return false
	case 18:
		return true
	}
	return false
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
	totalLength2, upperName2 := lenAndUpper2("haeum")
	fmt.Println(totalLength2, upperName2)

	repeatMe("haeum", "haeum1", "haeum2", "haeum3", "haeum4")

	result := superAdd(1, 2, 3, 4, 5, 6)
	fmt.Println(result)

	fmt.Println(canIDrink(16))
	fmt.Println(canIDrink2(18))

	// Pointers!
	a := 2
	b := a // 값 복사
	a = 10
	fmt.Println(a, b) // 10, 2

	a2 := 2
	b2 := &a2        // 메모리 주소 복사
	fmt.Println(*b2) // 2
	a = 5
	fmt.Println(&a2, b2) // 0xc000016080, 0xc000016080
	fmt.Println(*b2)     // 5

	a3 := 2
	b3 := &a3
	*b3 = 20
	fmt.Println(a) // 20
}
