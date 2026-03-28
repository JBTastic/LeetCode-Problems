# https://leetcode.com/problems/string-to-integer-atoi/

class Solution:
    def myAtoi(self, s: str) -> int:
        # Empty string is 0
        if not s:
            return 0
        
        # Rule 1: Whitespace
        s = s.strip()  # Remove leading and trailing whitespace
        
        # Check if the string is empty after trimming
        if not s:
            return 0
        
        # Rule 2: Signedness
        sign = 1
        if s[0] in ('+', '-'):
            sign = -1 if s[0] == '-' else 1
            s = s[1:]  # Remove the sign for further processing
        
        # Rule 3: Conversion
        # Remove leading zeros
        s = s.lstrip("0")
        
        # If we now have an empty string, return 0
        if not s:
            return 0
        
        # Search for position (index) where the digits end
        pos: int = -1
        for i in range(len(s)):
            if not s[i].isdigit():
                pos = i
                break
        
        # No digits found, return 0
        if pos == 0:
            return 0
        
        # If there was a non-digit character after some digit(s) we delete them
        if pos != -1:
            s = s[:pos]
        
        # Finally convert to number
        number = int(s)
        
        # Flip sign if needed
        number = number if sign == 1 else -number
        
        # Rule 4: Rounding
        if number < -2**31:
            return (-2**31)
        if number > (2**31) - 1:
            return (2**31) -1
        
        # Return without rounding
        return number


# Test cases
solution = Solution()
print(solution.myAtoi("42")) # Output: 42
print(solution.myAtoi("   -42")) # Output: -42
print(solution.myAtoi("1337c0d3")) # Output: 1337
print(solution.myAtoi("0-1")) # Output: 0
print(solution.myAtoi("words and 987")) # Output: 0
assert solution.myAtoi("42") == 42
assert solution.myAtoi("   -42") == -42
assert solution.myAtoi("1337c0d3") == 1337
assert solution.myAtoi("0-1") == 0
assert solution.myAtoi("words and 987") == 0