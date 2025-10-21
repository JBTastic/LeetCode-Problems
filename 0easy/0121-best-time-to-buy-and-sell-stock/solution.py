# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # Iterate through the list of prices with two pointers
        result = 0
        for i in range(len(prices) - 1):
            for j in range(i+1, len(prices)):
                if prices[j] > prices[i]:
                    tmp = prices[j] - prices[i]
                    if tmp > result:
                        result = tmp
        return result
                


def main():
    s = Solution()
    result = s.maxProfit([7, 1, 5, 3, 6, 4])
    result2 = s.maxProfit([7,6,4,3,1])
    print(result)  # Expected output: 5
    print(result2) # Expected output: 0

if __name__ == "__main__":
    main()
