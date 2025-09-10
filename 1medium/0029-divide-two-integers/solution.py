# https://leetcode.com/problems/divide-two-integers/

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend <= -2**31 and divisor == -1:
            return 2**31 - 1
        if dividend <= -2**31 and divisor == 1:
            return -2**31
        if dividend >= 2**31 - 1 and divisor == -1:
            return -2**31 + 1
        if dividend >= 2**31 - 1 and divisor == 1:
            return 2**31 - 1
        
        negative = (dividend < 0) ^ (divisor < 0)

        temp = abs(divisor)
        result = 0
        
        while temp <= abs(dividend):
            result += 1 # add 1 to final result
            temp += abs(divisor) # add temp to itself

        if negative:
            return result * -1
        return result


def main():
    s = Solution()
    print(f"{s.divide(10, 3)}, sould be 3")
    print(f"{s.divide(7, -3)}, should be -2") 
    print(f"{s.divide(2147483647, 2)}, should be 1073741823") 

if __name__ == "__main__":
    main()