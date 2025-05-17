// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/

class Solution {
    fun isCovered(ranges: Array<IntArray>, left: Int, right: Int): Boolean {
        var leftToRight= mutableListOf<Int>()

        for (i in left until right +1) {leftToRight.add(i)}
        for (range in ranges) {
            for (j in range[0]..range[1]) {
                leftToRight.remove(j)
            }
        }
        if (leftToRight.isEmpty()) {return true} else {return false}
    }
}

fun main() {
    val obj1 = Solution()

    val ranges1 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6))
    val left1 = 2
    val right1 = 5

    require(obj1.isCovered(ranges1, left1, right1) == true) {"Expected true, but got ${obj1.isCovered(ranges1, left1, right1)}"}
    println("Test passed")
}