# https://leetcode.com/problems/palindrome-number/

class Solution:
    def isPalindrome(self, x: int) -> bool:
        # Convert integer x to string y
        y: str = str(x)
        
        # Check if y is the same as its reverse
        return True if y == y[::-1] else False



# Test cases
solution = Solution()
print(solution.isPalindrome(121)) # Output: True
print(solution.isPalindrome(-121)) # Output: False
print(solution.isPalindrome(10)) # Output: False
assert solution.isPalindrome(121) == True
assert solution.isPalindrome(-121) == False
assert solution.isPalindrome(10) == False