// https://leetcode.com/problems/neighboring-bitwise-xor/description/?envType=daily-question&envId=2025-01-17

class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        // xor all elements from derived
        // if the result is 0, return true
        // else return false
        return (derived.reduce { acc, i -> acc xor i }) == 0
    }

    // faster solution
    fun fasterDoesValidArrayExist(derived: IntArray): Boolean {
        var x = 0
        for (i in derived) {
            x = x xor i
        }
        return x == 0
    }
}

fun main() {
    val obj = Solution()
    val derived = intArrayOf(1, 1, 0)
    val result = obj.doesValidArrayExist(derived)
    require(result == true) { "Expected true, got $result" }
    println("Test passed")
}