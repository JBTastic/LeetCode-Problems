//https://leetcode.com/problems/truncate-sentence/

package main

import (
	"fmt"
	"strings"
)

// func truncateSentence(s string, k int) string {
// 	words := strings.Fields(s)
// 	satz := strings.Join(words[:k], " ")
// 	return satz
// }

// converts the sentence to a list of words, then takes
// the first k words and joins them back with space as the seperator
func truncateSentence(s string, k int) string {
	return strings.Join(strings.Fields(s)[:k], " ")
}

func main() {
	fmt.Println(truncateSentence("Hello how are you Contestant", 4))         // Output: "Hello how are you"
	fmt.Println(truncateSentence("What is the solution to this problem", 4)) // Output: "What is the solution"
	fmt.Println(truncateSentence("chopper is not a tanuki", 5))              // Output: "chopper is not a tanuki"
}
