// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/?envType=daily-question&envId=2025-01-14

class Solution {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        var list = mutableListOf<Int>()
        var newA = A.toMutableList()
        var newB = B.toMutableList()

        for (i in 0 until A.size) {
            val intersection = newA.intersect(newB.toSet())
            list.add(0, intersection.size)
            newA.removeAt(newA.lastIndex)
            newB.removeAt(newB.lastIndex)
        }

        return list.toIntArray()
    }
}

fun main() {
    val obj = Solution()
    val A = intArrayOf(1,3,2,4)
    val B = intArrayOf(3,1,2,4)
    val result = obj.findThePrefixCommonArray(A, B)
    require(result.contentEquals(intArrayOf(0,2,3,4))) { "Expected [0, 2, 3, 4], but got ${result.contentToString()}" }
    println("Test passed")
}