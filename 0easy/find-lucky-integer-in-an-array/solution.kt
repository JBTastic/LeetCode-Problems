class Solution {
    fun findLucky(arr: IntArray): Int {
        var maxKey = -1
        val map: HashMap<Int, Int> = HashMap()
        for (value: Int in arr) {
            map[value] = map.getOrDefault(value, 0) + 1
        }

        for ((key: Int, count: Int) in map) {
            if (key == count) {
                maxKey = Math.max(maxKey, key)
            }
        }
        
        return maxKey
    }
}




fun main() {
    val nums = intArrayOf(2,2,3,4)
    val solution = Solution()
    val result = solution.findLucky(nums)
    require(result == 2) {"Expected 2, but got $result"}
    println("Passed")
}