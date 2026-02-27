# https://leetcode.com/problems/reverse-bits/

class Solution:
    def reverseBits(self, n: int) -> int:
        result = 0
        for _ in range(31):
            smallest = n & 1 # take rightmost bit of n
            result += smallest # add it into result
            result <<= 1 # shift result 1 to left to make space for the next bit
            n >>= 1 # shift n 1 to right to get the next bit in the next iteration
        return result


# Test cases
solution = Solution()
print(solution.reverseBits(43261596)) # Output: 964176192
print(solution.reverseBits(2)) # Output: 1073741824
assert solution.reverseBits(43261596) == 964176192
assert solution.reverseBits(2) == 1073741824