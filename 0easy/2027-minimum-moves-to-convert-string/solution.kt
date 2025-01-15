// https://leetcode.com/problems/minimum-moves-to-convert-string/

class Solution {
    fun minimumMoves(s: String): Int {
        var i = 0
        var count = 0
        while (i < s.length) {
            if (s[i] != 'X') {
                i++
            } else {
                i += 3
                count++
            }
        }
        return count
    }
}

fun main() {
    val obj = Solution()
    val s = "OXOX"
    val result = obj.minimumMoves(s)
    require(result == 1) { "Expected 1, but got $result" }
    println("Test passed")

}