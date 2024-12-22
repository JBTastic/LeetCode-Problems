class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: HashMap<Int, Int> = HashMap()

        for (i in nums.indices) {
            val difference = target - nums[i]
            if (map.containsKey(difference)) {
                return intArrayOf(map[difference]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}

fun main() {
    val nums1 = intArrayOf(2, 7, 11, 15)
    val target1 = 9
    val solution1 = Solution()
    val result1 = solution1.twoSum(nums1, target1)
    println(result1.joinToString()) // 0, 1
}