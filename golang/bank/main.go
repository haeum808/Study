package main

import (
	"accounts/accounts"
	"fmt"
)

func main() {
	account := accounts.NewAccount("haeum")
	account.Deposit(10)
	fmt.Println(account.Balance())
	err := account.Withdraw(20)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(account.Balance())
}
