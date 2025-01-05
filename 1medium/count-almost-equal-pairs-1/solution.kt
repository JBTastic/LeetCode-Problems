class Solution {
    fun compare(a: Int, b: Int): Boolean {

        // both numbers are already equal
        if (a == b) return true

        // both numbers are almost equal
        val aDigits = a.toString().toList()
        val bDigits = b.toString().toList()

        //check if both numbers have equal number of digits
        if (aDigits.size == bDigits.size) {

            //check in which position the numbers differ
            val differentIndices = aDigits.indices.filter { aDigits[it] != bDigits[it] }

            // if exactly two digits differ, check if switching them will make them equal
            return differentIndices.size == 2 && aDigits[differentIndices[0]] == bDigits[differentIndices[1]] && aDigits[differentIndices[1]] == bDigits[differentIndices[0]]
        
        } else if (Math.abs(aDigits.size - bDigits.size) == 1) {
            
            // if the numbers differ by one digit, check if the longer number has a 0, if so switch the 0 with the first digit and check if the numbers are equal
            val longer = if (aDigits.size > bDigits.size) aDigits else bDigits
            val shorter = if (aDigits.size < bDigits.size) aDigits else bDigits
            if (longer.contains('0')) {
                val index = longer.indexOf('0')
                val newLonger = longer.subList(1,index) + longer[0] + longer.subList(index + 1, longer.size)
                return newLonger == shorter
            }
            return false

        }
        return false
    }


    fun countPairs(nums: IntArray): Int {
        println()
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
    val solution = Solution()
    val nums1 = intArrayOf(3,12,30,17,21)
    val result1 = solution.countPairs(nums1)
    require(result1 == 2) {"Expected 2, but got $result1"}

    val nums2 = intArrayOf(5,12,8,5,5,1,20,3,10,10,5,5,5,5,1)
    val result2 = solution.countPairs(nums2)
    require(result2 == 27) {"Expected 27, but got $result2"}

    println("Passed")
}