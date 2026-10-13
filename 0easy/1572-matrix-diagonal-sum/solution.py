class Solution:
    def diagonalSum(self, mat: list[list[int]]) -> int:
        n = len(mat)
        if n == 1:
            return mat[0][0]
        sum = 0
        for i in range(n):
            sum += mat[i][i]
            sum += mat[i][n-i-1]
        if n % 2 != 0:
            sum -= mat[n//2][n//2]
        return sum

s = Solution()
result = s.diagonalSum([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
assert result == 25, f"Expected 25, but got {result}"
result2 = s.diagonalSum([[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]])
assert result2 == 8, f"Expected 8, but got {result2}"
result3 = s.diagonalSum([[5]])
assert result3 == 5, f"Expected 5, but got {result3}"