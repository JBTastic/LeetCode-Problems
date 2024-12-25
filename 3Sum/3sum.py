class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:

        solutions = []
        hashmap = {}

        for i, num in enumerate(nums) :
            difference = target - num

            if difference in hashmap :
                solutions.append([difference, num])
            
            hashmap[num] = i

        return solutions


    def threeSum(self, nums: list[int]) -> list[list[int]]:

        solutions = []
        nums.sort()
        
        # do the two-sum problem, but as first number take any single one from the list
        for i, firstNum in enumerate(nums) :

            if i > 0 and nums[i] == nums[i-1] :
                continue

            target = -firstNum
            twoSum_nums = nums[i+1:]

            twoSum_answer = self.twoSum(twoSum_nums, target)
            if twoSum_answer != [] :
                for pair in twoSum_answer:
                    triplet = [firstNum] + pair
                    if triplet not in solutions:
                        solutions.append(triplet) 

        return solutions


    

        

print(Solution().threeSum([-1,0,1,2,-1,-4]), "\n")
print(Solution().threeSum([0,1,1]), "\n")
print(Solution().threeSum([0,0,0]))
print(Solution().threeSum([0,0,0,0]))

