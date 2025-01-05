class Solution {
    fun countPairs(nums: IntArray): Int {
        return -1
    }
}


fun main() {
    val nums = intArrayOf(3,12,30,17,21)
    val solution = Solution()
    val result = solution.countPairs(nums)
    require(result == 2) {"Expected 2, but got $result"}
    println("Passed")
}