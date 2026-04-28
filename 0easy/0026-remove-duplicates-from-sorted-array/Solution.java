// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class Solution {
    public int removeDuplicates(int[] nums) {
        // Early return
        if (nums.length == 0) 
        {
            return 0;
        }

        // k will keep track of the position of the last unique element
        int k = 1;

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        int result = solution.removeDuplicates(nums);
        System.out.printf("Result: %d; Expected: 2%n", result); // Output: 2

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result2 = solution.removeDuplicates(nums2);
        System.out.printf("Result: %d; Expected: 5%n", result2); // Output: 5
    }
}

