// https://leetcode.com/problems/plus-one/

using System;
using System.Text.Json;

Solution solution = new Solution();
int[] digits = { 1, 2, 9 };
Console.WriteLine(JsonSerializer.Serialize(solution.PlusOne(digits)));


public class Solution
{
    public int[] PlusOne(int[] digits)
    {
        for (int i = digits.Length - 1; i >= 0; i--)
        {
            if (digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If the number was all 9s
        int[] result = new int[digits.Length + 1];
        result[0] = 1;
        return result;
    }
}
