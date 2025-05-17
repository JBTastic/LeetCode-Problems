// https://leetcode.com/problems/bitwise-xor-of-all-pairings/

class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        val nums1Size = nums1.size
        val nums2Size = nums2.size

        // since xor is associative and commutative
        if (nums1Size % 2 == 0 && nums2Size % 2 == 0) {
            return 0
        } else if (nums1Size % 2 == 0){
            return nums1.reduce { acc, i -> acc xor i }
        } else if (nums2Size % 2 == 0) {
            return nums2.reduce { acc, i -> acc xor i }
        } else {
            return nums1.reduce { acc, i -> acc xor i } xor nums2.reduce { acc, i -> acc xor i }
        }
    }
}

fun main() {
    val obj = Solution()
    val nums1 = intArrayOf(2,1,3)
    val nums2 = intArrayOf(10,2,5,0)
    val result = obj.xorAllNums(nums1, nums2)
    require(result == 13) { "Expected 13, but got $result" }
    println(result) // Output: 13
}