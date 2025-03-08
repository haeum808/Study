package main

import (
	"fmt"
	"mydict/mydict"
)

func main() {
	dictionary := mydict.Dictionary{"first": "First word"}
	baseWord := "hello"
	dictionary.Add(baseWord, "First")
	dictionary.Delete(baseWord)
	word, err := dictionary.Search(baseWord)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(word)
}
