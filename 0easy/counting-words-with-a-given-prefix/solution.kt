class Solution {
    fun prefixCount(words: Array<String>, pref: String): Int {
        return words.count { it.startsWith(pref) } // even faster would be using .subSequence instead of .startsWith for some reason
    }

    fun prefixCountFaster(words: Array<String>, pref: String): Int {
        return words.count { it.length >= pref.length && it.subSequence(0, pref.length) == pref }
    }
}

fun main() {
    val obj1 = Solution()

    val words1 = arrayOf("pay","attention","practice","attend")

    val pref1 = "at"

    val expected1 = 2
    
    val result1 = obj1.prefixCount(words1, pref1)
    require(result1 == expected1) { "Expected ${expected1}, but got $result1" }
    println("Test passed")
}