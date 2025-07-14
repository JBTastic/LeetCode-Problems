//leetcode.com/problems/expression-add-operators/

package main

func addOperators(num string, target int) []string {
	var result []string
	var backtrack func(index int, path string, prevNum int, currentValue int)

	backtrack = func(index int, path string, prevNum int, currentValue int) {
		if index == len(num) {
			if currentValue == target {
				result = append(result, path)
			}
			return
		}

		for i := index; i < len(num); i++ {
			if i > index && num[index] == '0' { // Skip leading zeroes
				break
			}
			numStr := num[index : i+1]
			numVal := 0
			for _, c := range numStr {
				numVal = numVal*10 + int(c-'0')
			}

			if index == 0 {
				backtrack(i+1, numStr, numVal, numVal)
			} else {
				backtrack(i+1, path+"+"+numStr, numVal, currentValue+numVal)
				backtrack(i+1, path+"-"+numStr, -numVal, currentValue-numVal)
				backtrack(i+1, path+"*"+numStr, prevNum*numVal, currentValue-prevNum+prevNum*numVal)
			}
		}
	}

	backtrack(0, "", 0, 0)
	return result
}

func main() {
	// Example usage
	num := "123"
	target := 6
	result := addOperators(num, target)
	for i := range result {
		print(result[i], " ")
	} // ["1*2*3", "1+2+3"]
}
