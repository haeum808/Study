package main

import (
	"fmt"
	"time"
)

func main() {
	channel := make(chan string)
	people := [5]string{"haeum1", "joon1", "haeum2", "joon2", "haeum3"}
	for _, person := range people {
		go isSexy(person, channel)
	}
	for i:=0; i<len(people); i++ {
		fmt.Println(<-channel)
	}
}

func sexyCount(person string) {
	for i := 0; i < 10; i++ {
		fmt.Println(person, "is sexy", i)
		time.Sleep(time.Second)
	}
}

func isSexy(person string, channel chan string) {
	time.Sleep(time.Second * 10)
	channel <- person + " is sexy"
}
