class Solution {
    fun countPairs(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in 0 until nums.size -1) {
            for (j in i+1 until nums.size) {
                if (nums[i] == nums[j] && i*j % k == 0) {
                    count++
                }
            }
        }
        return count
    }

    fun countPairsBetter(nums: IntArray, k: Int): Int {
        val map: HashMap<Int, MutableList<Int>> = HashMap()
        var count: Int = 0
        for ((index: Int, value: Int) in nums.withIndex()) {
            map.computeIfAbsent(value) {mutableListOf()}.add(index)
        }
        for((_, indices: MutableList<Int>) in map) {
            val size: Int = indices.size
            for (i in 0 until size) {
                for (j in i+1 until size) {
                    if ((indices[i] * indices[j]) % k == 0) {
                        count++
                    }
                }
            }
        }
        return count
    }
}




fun main() {
    val nums = intArrayOf(3, 1, 2, 2, 2, 1, 3)
    val k = 2
    val solution = Solution()
    val result = solution.countPairsBetter(nums, k)
    require(result == 4) {"Expected 4, but got $result"}
    println("Passed")
}