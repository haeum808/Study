package main

import (
	"accounts/accounts"
	"fmt"
)

func main() {
	account := accounts.NewAccount("haeum")
	account.Deposit(10)
	fmt.Println(account)
}
