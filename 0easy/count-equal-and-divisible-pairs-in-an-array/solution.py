## Used Kotlin instead


class Solution:
    def countPairs(self, nums: list[int], k: int) -> int:
        pass

def test_countPairs_example1():
    solution = Solution()
    nums = [3, 1, 2, 2, 2, 1, 3]
    k = 2
    expected = 4
    result = solution.countPairs(nums, k)
    assert result == expected, f"Expected {expected}, but got {result}"

def test_countPairs_example2():
    solution = Solution()
    nums = [1, 2, 3, 4]
    k = 1
    expected = 0
    result = solution.countPairs(nums, k)
    assert result == expected, f"Expected {expected}, but got {result}"

def test_countPairs_empty_list():
    solution = Solution()
    nums = []
    k = 5
    expected = 0
    result = solution.countPairs(nums, k)
    assert result == expected, f"Expected {expected}, but got {result}"

test_countPairs_example1()