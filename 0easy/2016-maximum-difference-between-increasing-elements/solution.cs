// https://leetcode.com/problems/maximum-difference-between-increasing-elements/

public class Solution {
    public int MaximumDifference(int[] nums) {
        int result = -1;
         for (int i = 0; i < nums.Length - 1; i++)
        {
            for (int j = i; j < nums.Length; j++)
            {
                if (nums[i] < nums[j] && (nums[j] - nums[i] > result))
                {
                    result = nums[j] - nums[i];
                }
            }
        }
        return result;
    }
}

public static class Program {
    public static void Main() {
        Solution solution = new Solution();
        int[] nums = {7,1,5,4};
        int result = solution.MaximumDifference(nums);
        Console.WriteLine($"Result: {result}\nCorrect: 4\n"); // 4

        int[] nums2 = {9,4,3,2};
        int result2 = solution.MaximumDifference(nums2);
        Console.WriteLine($"Result: {result2}\nCorrect: -1"); // -1

    }
}
