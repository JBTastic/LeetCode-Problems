// https://leetcode.com/problems/count-almost-equal-pairs-i/

class Solution {

    fun compare(a: Int, b: Int): Boolean {

        // both numbers are already equal
        if (a == b) return true

        // both numbers are almost equal
        val aDigits = a.toString().toMutableList()
        val bDigits = b.toString().toMutableList()

        //check if both numbers have equal number of digits
        if (aDigits.size == bDigits.size) {

            //check in which position the numbers differ
            val differentIndices = aDigits.indices.filter { aDigits[it] != bDigits[it] }

            // if exactly two digits differ, check if switching them will make them equal
            return differentIndices.size == 2 && aDigits[differentIndices[0]] == bDigits[differentIndices[1]] && aDigits[differentIndices[1]] == bDigits[differentIndices[0]]
        
        } else {
            
            // check which number is longer
            val longer = if (aDigits.size > bDigits.size) aDigits else bDigits
            val shorter = if (aDigits.size < bDigits.size) aDigits else bDigits

            // now check if the longer number has a 0 and where the zeros are, then for each zero swap it with the first digit and check if the numbers are equal
            val zeroIndices = longer.indices.filter { longer[it] == '0' }
            if (zeroIndices.isNotEmpty()) {
                for (index in zeroIndices) {

                    // create a copy of list to avoid modifying the original list
                    var newLonger = longer.map { it } as MutableList<Char>

                    // swap the zero with the first digit
                    newLonger[index] = newLonger[0]
                    newLonger[0] = '0'

                    val result = newLonger.dropWhile { it == '0' }

                    if (result == shorter) {
                        return true
                    }
                }
            }
        }
        return false
    }


    fun countPairs(nums: IntArray): Int {
        var counter = 0
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (compare(nums[i], nums[j])) {
                    counter++
                } else {
                    var a = nums[i]
                    var b = nums[j]
                }
            }
        }
        return counter
    }
}


fun main() {
    val solution = Solution()
    // val nums1 = intArrayOf(3,12,30,17,21)
    // val result1 = solution.countPairs(nums1)
    // require(result1 == 2) {"Expected 2, but got $result1"}

    // val nums2 = intArrayOf(5,12,8,5,5,1,20,3,10,10,5,5,5,5,1)
    // val result2 = solution.countPairs(nums2)
    // require(result2 == 27) {"Expected 27, but got $result2"}

    // val num4 = intArrayOf(30003, 33)
    // val result4 = solution.countPairs(num4)
    // print(result4)

    val nums3 = intArrayOf(886595,767627,6691,593887,857750,919155,830918,593887,593788,593788,660078,598873,310196,668007,597883,983587,897853,668700,435383,953887,631608,897853,953887,240754,593887,597883,455127,627877,643862,660087,893587,129173,228736,627877,775850,875750,50701,830255,751,729113,684778,114586,154186,593887,668700,238726)
    val result3 = solution.countPairs(nums3)
    require(result3 == 59) {"Expected 59, but got $result3"}

    println("Passed")
}