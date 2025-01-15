// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/

class Solution {
    fun countHillValley(nums: IntArray): Int {
        var i = 1
        var counter = 0
        var numsList = nums.toMutableList()
        while (i < numsList.size-1) {

            // if we have two consecutive same numbers, remove the second one and do the same check again
            if (numsList[i] == numsList[i+1]) {
                numsList.removeAt(i)

            // check for valley
            } else if (numsList[i] < numsList[i-1] && numsList[i] < numsList[i+1]) {
                counter++
                i++

            // check for hill
            } else if (numsList[i] > numsList[i-1] && numsList[i] > numsList[i+1]) {
                counter++
                i++

            // neither valley nor hill, move to the next number
            } else i++
        }
        return counter
    }

    // Faster version
    fun betterCountHillValley(nums: IntArray): Int {
        var up: Boolean? = null
        var result = 0
        for (i in 0..<nums.size-1) {

            // if its the same number, skip
            if(nums[i] == nums[i + 1]) continue

            // check if the next number is smaller
            if(nums[i] > nums[i + 1] ) {

                // if the previous number was also smaller, it's a hill
                if(up == true) result++

                // since the next number is smaller, set up to false
                up = false

            // check if the next number is bigger
            } else if(nums[i] < nums[i + 1]) {

                // if the previous number was also bigger, it's a valley
                if(up == false) result++ 

                // since the next number is bigger, set up to true
                up = true
            }
        }
        return result
    }
}

fun main() {
    val obj = Solution()
    val nums = intArrayOf(5,7,7,1,7)
    val result = obj.countHillValley(nums)
    require(result == 2) { "Expected 2, but got $result" }
    println("Test passed")
}