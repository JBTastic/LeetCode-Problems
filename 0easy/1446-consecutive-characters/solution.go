// https://leetcode.com/problems/consecutive-characters/

package main

func maxPower(s string) int {
    curr := 1
    max := 1
    for pos, _ := range s {
        if pos == 0 || s[pos] != s[pos-1] {
            curr = 1
        } else {
            curr++
        }
        if curr > max {
            max = curr
        }
    }
    return max
}

func main() {
    // Example usage
    s := "leetcode"
    result := maxPower(s)
    println(result) // Output: 2
}
