// https://leetcode.com/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2025-01-20

class Solution {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val rowAndColumns = HashMap<Int, Pair<Int, Int>>()

        // go through the matrix and store the row and column of each number
        for (row in mat.indices) {
            for (column in mat[row].indices) {
                val number = mat[row][column]
                rowAndColumns[number] = Pair(row, column)
            }
        }

        // go through the array and add 1 to the row and column of each number
        // when the row equals the amount of columns or the column equals the amount of rows, return the index of the number in arr
        val rowMap = HashMap<Int, Int>()
        val columnMap = HashMap<Int, Int>()

        for (i in arr.indices) {
            val (row, column) = rowAndColumns[arr[i]]!!
            rowMap[row] = rowMap.getOrDefault(row, 0) + 1
            columnMap[column] = columnMap.getOrDefault(column, 0) + 1

            if (rowMap[row] == mat[0].size || columnMap[column] == mat.size) {
                return i
            }
        }

        // if something didn't go as expected, return -1
        return -1
    }
}

fun main() {
    val obj = Solution()
    val arr = intArrayOf(1,3,4,2)
    val mat = arrayOf(intArrayOf(1,4), intArrayOf(2,3))
    val result = obj.firstCompleteIndex(arr, mat)
    require(result == 2) { "Expected 2, got $result" }
    println("Test passed")
}