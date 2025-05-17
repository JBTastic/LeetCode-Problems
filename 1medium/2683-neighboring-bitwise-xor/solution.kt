// https://leetcode.com/problems/neighboring-bitwise-xor/

class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        
        // xor all elements from derived
        // if the result is 0, return true
        // else return false
        return (derived.reduce { acc, i -> acc xor i }) == 0
    }

    // better solution
    fun betterDoesValidArrayExist(derived: IntArray): Boolean {
        var x = 0

        // add all the numbers in derived and check if the sum is even
        for (i in derived) {
            x += i
        }
        return x%2 == 0
    }
}

fun main() {
    val obj = Solution()
    val derived = intArrayOf(1, 1, 0)
    val result = obj.doesValidArrayExist(derived)
    require(result == true) { "Expected true, got $result" }
    println("Test passed")
}