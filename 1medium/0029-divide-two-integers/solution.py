# https://leetcode.com/problems/divide-two-integers/

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:

        # Edge cases for overflow
        if dividend <= -2**31 and divisor == -1:
            return 2**31 - 1
        if dividend <= -2**31 and divisor == 1:
            return -2**31
        if dividend >= 2**31 - 1 and divisor == -1:
            return -2**31 + 1
        if dividend >= 2**31 - 1 and divisor == 1:
            return 2**31 - 1
        
        # Determine the sign of the result
        negative = (dividend < 0) ^ (divisor < 0)

        # Work with positive numbers
        dividend = abs(dividend)
        divisor = abs(divisor)

        # Initialize variables
        result = 0
        remaining = dividend

        # repeat until remainder is smaller than divisor
        while remaining >= divisor:
            # start with divisor
            temp = divisor
            multiple = 1

            # 1. step: bitshift left to get close to the current remainder
            while (temp << 1) <= remaining:
                temp <<= 1 # bitshift left, multiply by 2
                multiple <<= 1  # bitshift left, multiply by 2

            # subtract this chunk
            remaining -= temp
            result += multiple

        # if negative, flip sign
        if negative:
            result = -result
        return result


def main():
    s = Solution()
    print(f"{s.divide(10, 3)}, sould be 3")
    print(f"{s.divide(7, -3)}, should be -2") 
    print(f"{s.divide(2147483647, 2)}, should be 1073741823") 

if __name__ == "__main__":
    main()