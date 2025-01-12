class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:

        # use set for the solutions to avoid duplicates
        solutions = set()
        nums.sort()
        
        for i in range(len(nums)):
            
            # skip doing two times the same
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            # target is what the remaining two numbers should add up to
            target = -nums[i]
            hashmap = {}
            
            # go through all the numbers after the first one and solve the two-sum problem
            for j in range(i + 1, len(nums)):
                difference = target - nums[j]

                if difference in hashmap:
                    triplet = tuple(sorted([nums[i], nums[j], difference]))
                    solutions.add(triplet)

                hashmap[nums[j]] = True

        # return all the triplets that are solutions in a list
        return [list(triplet) for triplet in solutions]


        

print(Solution().threeSum([-1,0,1,2,-1,-4]), "\n")
print(Solution().threeSum([0,1,1]), "\n")
print(Solution().threeSum([0,0,0]), "\n")
print(Solution().threeSum([0,0,0,0]))