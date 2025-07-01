// https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/

package main

func countCompleteDayPairs(hours []int) int {
	count := 0
	for i := 0; i < len(hours); i++ {
		for j := i + 1; j < len(hours); j++ {
			if (hours[i]+hours[j])%24 == 0 {
				count++
			}
		}
	}
	return count
}

func main() {
	// Example usage:
	hours := []int{12, 12, 30, 24, 24}
	result := countCompleteDayPairs(hours)
	println(result, "Expected: 2") // Output: 2

	hours2 := []int{72, 48, 24, 3}
	result2 := countCompleteDayPairs(hours2)
	println(result2, "Expected: 3") // Output: 3
}
