class Solution {
    fun compare(a: Int, b: Int): Boolean {
        println("Comparing $a and $b")

        // both numbers are already equal
        if (a == b) return true

        // both numbers are almost equal
        val aDigits = a.toString().toList()
        val bDigits = b.toString().toList()

        //check if both numbers have equal number of digits
        if (aDigits.size != bDigits.size) return false

        //check in which position the numbers differ
        val differentIndices = aDigits.indices.filter { aDigits[it] != bDigits[it] }

        // if exactly two digits differ, check if switching them will make them equal
        return differentIndices.size == 2 && aDigits[differentIndices[0]] == bDigits[differentIndices[1]] && aDigits[differentIndices[1]] == bDigits[differentIndices[0]]
    }


    fun countPairs(nums: IntArray): Int {
        var counter = 0
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (compare(nums[i], nums[j])) {
                    counter++
                }
            }
        }
        return counter
    }
}


fun main() {
    val nums = intArrayOf(3,12,30,17,21)
    val solution = Solution()
    val result = solution.countPairs(nums)
    require(result == 2) {"Expected 2, but got $result"}
    println("Passed")
}