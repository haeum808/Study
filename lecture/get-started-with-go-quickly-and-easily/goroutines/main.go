package main

import (
	"fmt"
	"time"
)

func main() {
	channel := make(chan bool)
	people := [2]string{"haeum", "joon"}
	for _, person := range people {
		go isSexy(person, channel)
	}
	fmt.Println(<-channel)
	fmt.Println(<-channel)
}

func sexyCount(person string) {
	for i := 0; i < 10; i++ {
		fmt.Println(person, "is sexy", i)
		time.Sleep(time.Second)
	}
}

func isSexy(person string, channel chan bool) {
	time.Sleep(time.Second * 5)
	fmt.Println(person)
	channel <- true
}
