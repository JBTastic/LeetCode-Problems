# https://leetcode.com/problems/number-of-1-bits/

class Solution:
    def hammingWeight(self, n: int) -> int:
        # Convert n to binary using bin()
        # Cut off the '0b' prefix using [2:]
        # Convert binary string to list of integer numbers using list comprehension and int()
        # Use sum() to sum them up
        return sum([int(char) for char in bin(n)[2:]])

# Test cases
solution = Solution()
assert solution.hammingWeight(1) == 1
assert solution.hammingWeight(2) == 1
assert solution.hammingWeight(7) == 3
assert solution.hammingWeight(255) == 8
print("All test cases passed!")