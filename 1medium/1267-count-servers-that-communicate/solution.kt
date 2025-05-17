// https://leetcode.com/problems/count-servers-that-communicate/

class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val rows = HashMap<Int, Int>()
        val columns = HashMap<Int, Int>()

        // go through the matrix and store the row and column of each server
        for (row in grid.indices) {
            for (column in grid[row].indices) {
                val number = grid[row][column]
                if (number == 1) {
                    rows[row] = rows.getOrDefault(row, 0) + 1
                    columns[column] = columns.getOrDefault(column, 0) + 1
                }
            }
        }

        var count = 0
        // go through the matrix and add 1 to the result if the row or column has more than 1 server
        for (row in grid.indices) {
            for (column in grid[row].indices) {
                if (grid[row][column] == 1 &&
                    (rows[row]!! > 1 || columns[column]!! > 1)) {
                    count++
                }
            }
        }

        return count
    }
}

fun main() {
    val obj = Solution()
    val grid = arrayOf(intArrayOf(1,0), intArrayOf(0,1))
    val result = obj.countServers(grid)
    require(result == 0) { "Expected 0, got $result" }
    println("Test passed")

    val grid2 = arrayOf(intArrayOf(1,0), intArrayOf(1,1))
    val result2 = obj.countServers(grid2)
    require(result2 == 3) { "Expected 3, got $result2" }
    println("Test passed")

    val grid3 = arrayOf(intArrayOf(1,1,0,0), intArrayOf(0,0,1,0), intArrayOf(0,0,1,0), intArrayOf(0,0,0,1))
    val result3 = obj.countServers(grid3)
    require(result3 == 4) { "Expected 4, got $result3" }
    println("Test passed")
}