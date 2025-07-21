// https://leetcode.com/problems/sort-colors/

package main
import "fmt"

func sortColors(nums []int) {
    // iterate through the array len(nums)-1 times in the worst case
    for i := 0; i < len(nums)-1; i++ {
        swapped := false
        // iterate through the indices, only until len(nums)-1-i since
        // after the first iteration the biggest number is already all
        // the way to the right, then the second biggest number, and so on, only until len(nums)-1-i since
        // after the first iteration the biggest number is already all
        // the way to the right, then the second biggest number, and so on
        for j := 0; j < len(nums)-1-i; j++ {
            if nums[j] > nums[j+1] {
                // swap the numbers
                nums[j], nums[j+1] = nums[j+1], nums[j]
                swapped = true
            }
        }
        // if we haven't swapped any numbers, the array is sorted
        if !swapped {
            break
        }
    }
    // print the sorted array, as there is no return value
    fmt.Println(nums)
}

func main() {
    // Example usage
    nums := []int{2, 0, 2, 1, 1, 0}
    sortColors(nums)
    // Output should be sorted array: [0, 0, 1, 1, 2, 2]
}
