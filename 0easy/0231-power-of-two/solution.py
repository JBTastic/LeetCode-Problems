# https://leetcode.com/problems/power-of-two/

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # A number that is a power of two has exactly one bit set to one in its binary representation.
        # First we delete all cases, where n has only one bit set to one but its not a power of two.
        if n <= 0:
            return False

        # Then we check if n has only one bit set to one by using the bitwise AND operation with n-1.
        return (n & (n - 1)) == 0 # e.g. 16 in binary is 10000, and 15 in binary is 01111. The bitwise AND of 16 and 15 is 0, which means that 16 has only one bit set to one and is a power of two.
    
# Test cases
solution = Solution()
assert solution.isPowerOfTwo(1) == True
assert solution.isPowerOfTwo(16) == True
assert solution.isPowerOfTwo(256) == True
assert solution.isPowerOfTwo(0) == False
assert solution.isPowerOfTwo(-2) == False
assert solution.isPowerOfTwo(1024) == True
print("All test cases passed!")