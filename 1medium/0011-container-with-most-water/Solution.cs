// https://leetcode.com/problems/container-with-most-water/

public class Solution
{
    public int MaxArea(int[] height)
    {
        // Two pointers, one left one right
        int l = 0;
        int r = height.Length - 1;
        int maxArea = 0;

        while (l < r)
        {
            maxArea = Math.Max(Math.Min(height[l], height[r]) * (r - l), maxArea);

            // Move the pointer that has the smaller height, since moving the larger one won't increase the area
            if (height[l] < height[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }

        return maxArea;
    }
}

public class Program
{
    public static void Main()
    {
        var s = new Solution();
        int result = s.MaxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        Console.WriteLine($"\nResult: {result}\nCorrect: 49\n"); // 49
    }
}