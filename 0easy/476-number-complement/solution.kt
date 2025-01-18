// https://leetcode.com/problems/number-complement/?envType=daily-question&envId=2025-01-18

class Solution {
    fun findComplement(num: Int): Int {

        // find number of relevant bits
        val bitCount = Integer.SIZE - Integer.numberOfLeadingZeros(num)

        /*
        create a mask with all relevant bits set to 1

        it works by taking the numer 1 (1 in binary), shifting
        its bit "bitCount" amount of times to the left
        (in the case of num = 5 it's 1000 in binary)
        and subtracting 1 (111 in binary) so we get a mask we can
        and gate our inverted number with
         */ 
        val mask = (1 shl bitCount) - 1

        // return the inverted number that's and-gated with the mask
        return num.inv() and mask

    }
}