class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        hashmap = {}
        for i, num in enumerate(nums) :
            difference = target - num
            if difference in hashmap :
                return [hashmap[difference], i]
            hashmap[num] = i
        return []
        


print("True" if Solution().twoSum([2,7,11,15], 13) == [0,2] else "False")
print("True" if Solution().twoSum([3,2,4], 6) == [1,2] else "False")
print("True" if Solution().twoSum([3,3], 6) == [0,1] else "False")
