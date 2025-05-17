// https://leetcode.com/problems/convert-1d-array-into-2d-array/

class Solution {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {

        // test if original size fits m * n, if it doesn't, return empty array
        if (original.size != m * n) {
            return arrayOf()
        }

        // create 2D array
        var result = Array(m) { IntArray(n) }

        // go through every row and column and add their respective elements from original to result
        for (rowIndex in 0 until m) {
            for (columnIndex in 0 until n) {
                val index = rowIndex * n + columnIndex
                result[rowIndex][columnIndex] = original[index]
            }
        }
        return result
    }
}

fun main(){
    val obj = Solution()
    val original = intArrayOf(1,2,3,4)
    val m = 2
    val n = 2
    require(obj.construct2DArray(original, m, n).contentDeepEquals(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))) { "Expected [[1, 2], [3, 4]], but got ${obj.construct2DArray(original, m, n).contentDeepToString()}" }
    println("Test passed")
}