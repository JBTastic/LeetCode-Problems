// https://leetcode.com/problems/minimum-length-of-string-after-operations/

class Solution {
    fun minimumLength(s: String): Int {
        var hashMap = mutableMapOf<Char, Int>()
        var counter = 0

        // key in the hashMap is the character, value is the count of the character in the string
        for (c in s) {
            hashMap[c] = hashMap.getOrDefault(c, 0) + 1
        }

        // if the count of the character is less or equal to 2, it cant be reduced so add the value to the counter
        // if the count is odd, it can be reduced to 1
        // if the count is even, it can be reduced to 2
        for ((key, value) in hashMap) {
            if (value <= 2) {
                counter += value
            } else if (value % 2 == 1) {
                counter++
            } else {
                counter += 2
            }
        }
        return counter
    }
}

fun main() {
    val obj = Solution()
    val s = "ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj"
    require(obj.minimumLength(s) == 38) { "Expected 38, but got ${obj.minimumLength(s)}" }
    println("Test passed")
}