# https://leetcode.com/problems/reverse-integer/

class Solution:
    def reverse(self, x: int) -> int:
        # Convert number to string
        number: str = str(x)
        
        # Check for negative sign and remove it if it exists
        negative: bool = number[0] == '-'
        if negative:
            number = number[1:]
        
        # Reverse the number string
        reversed_number: str = number[::-1]

        # Convert back to integer and apply negative sign if needed
        result: int = int(reversed_number)
        
        # If number is out of 32-bit signed integer range, return 0
        if result < -2**31 or result > 2**31 - 1:
            return 0
        
        # If negative, flip the sign back
        if negative:
            result = -result

        return result

# Test cases
solution = Solution()
print(solution.reverse(123)) # Output: 3
print(solution.reverse(-123)) # Output: -321
print(solution.reverse(120)) # Output: 21
assert solution.reverse(123) == 321
assert solution.reverse(-123) == -321
assert solution.reverse(120) == 21