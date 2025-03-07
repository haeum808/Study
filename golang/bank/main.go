package main

import (
	"accounts/accounts"
	"fmt"
)

func main() {
	account := accounts.NewAccount("haeum")
	fmt.Println(account)
}
