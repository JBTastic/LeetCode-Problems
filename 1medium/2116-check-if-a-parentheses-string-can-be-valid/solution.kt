// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/

class Solution {
    fun canBeValid(s: String, locked: String): Boolean {
        // if number of parentheses is uneven, return false
        if (locked.length % 2 != 0) {return false}

        // go through s from left to right
        var openCount = 0
        var flexibleCount = 0
        for (i in s.indices) {

            // if locked is 0 we can change the parenthesis, so increase flexibleCount
            if (locked[i] == '0') {
                flexibleCount++

            // if the parenthesis is already open, increase openCount
            } else if (s[i] == '(') {
                openCount++

            // if its a closed parenthesis we can not change
            } else {

                // if we have open parentheses left, decrease it by 1
                if (openCount > 0) {
                    openCount--

                // if we have no open parentheses but flexible ones left, decrease them by 1
                } else if (flexibleCount > 0) {
                    flexibleCount--

                // if we have closed parentheses left but no open or flexible ones, return flase
                } else {
                    return false
                }
            }
        }

        // too many open parentheses
        if (openCount > flexibleCount) {return false}

        // go through s from right to left too
        var closedCount = 0
        flexibleCount = 0
        for (i in s.indices.reversed()) {

            // if locked is 0 we can change the parenthesis, so increase flexibleCount
            if (locked[i] == '0') {
                flexibleCount++

            // if the parenthesis is already closed, increase closedCount
            } else if (s[i] == ')') {
                closedCount++

            // if its an open parenthesis we can not change
            } else {

                // if we have closed parentheses left, decrease it by 1
                if (closedCount > 0) {
                    closedCount--

                // if we have no closed parentheses but flexible ones left, decrease them by 1
                } else if (flexibleCount > 0) {
                    flexibleCount--

                // if we have open parentheses left but no closed or flexible ones, return flase
                } else {
                    return false
                }
            }
        }

        // check if we have too many closed parentheses, if so return false, else true
        return closedCount <= flexibleCount
    }
}