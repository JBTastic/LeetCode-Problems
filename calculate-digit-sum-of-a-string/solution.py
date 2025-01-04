class Solution:
    def digitSum(self, s: str, k: int) -> str:
        while len(s) > k:
            new_s = [s[i:i+k] for i in range(0, len(s), k)]
            s = ""
            helper = 0
            for group in new_s:
                helper = int(group)
                s += str(sum(map(int, str(helper))))
        return s



        
# Test case
s = "11111222223"
k = 3
solution = Solution()
result = solution.digitSum(s, k)
print(result)