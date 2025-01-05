class Solution {
    fun findLucky(arr: IntArray): Int {
        val map: HashMap<Int, Int> = HashMap()
        for ((index: Int, value: Int) in arr.withIndex()) {
            map.computeIfAbsent(value) {Int}.add(index)
        }
    }
}




fun main() {
    val nums = intArrayOf(2,2,3,4)
    val solution = Solution()
    val result = solution.findLucky(nums)
    require(result == 2) {"Expected 2, but got $result"}
    println(result)
}