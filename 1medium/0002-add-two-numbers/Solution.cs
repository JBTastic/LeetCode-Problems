// https://leetcode.com/problems/add-two-numbers/

#region Solution
using System.Numerics;

public class Solution
{
    private BigInteger GetNumFromListNode(ListNode node)
    {
        BigInteger num = 0;
        int digitIndex = 0; // Indicates at which index we are from right to left

        ListNode cur = node;
        while (true)
        {
            num += cur.val * BigInteger.Pow(10, digitIndex); // Add the current digit to the number, multiplying it by 10^digitIndex to place it in the correct position
            digitIndex += 1;

            if (cur.next != null) // If there is a next node, move to it
            {
                cur = cur.next;
            }
            else // If there is no next node, we have reached the end of the linked list
            {
                break;
            }
        }
        return num;
    }
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
    {
        BigInteger num1 = GetNumFromListNode(l1);
        BigInteger num2 = GetNumFromListNode(l2);

        BigInteger sum = num1 + num2;

        if (sum == 0) // If the sum is 0, return a linked list with a single node with value 0
        {
            return new ListNode(0);
        }

        ListNode result = new ListNode();
        ListNode? cur = result;
        while (sum > 0)
        {
            int leastSignificant = (int)(sum % 10); // Get least significant digit of the sum
            cur.val = leastSignificant;
            sum -= leastSignificant;
            if (sum == 0) // If the sum is now 0, we are done and can break out of the loop
            {
                break;
            }
            sum /= 10;
            // Now sum is the remaining part of the number after removing the least significant digit
            cur.next = new ListNode();
            cur = cur.next;
        }
        return result;
    }
}
#endregion

#region Helper for VSCode
public class ListNode
{
    public int val;
    public ListNode? next; // Had to change it to a nullable type
    public ListNode(int val = 0, ListNode? next = null) // Had to change it to a nullable type
    {
        this.val = val;
        this.next = next;
    }
}

public class Program
{
    /// <summary>
    /// Helper method created by ChatGPT to help pretty-print a linked list in the format "val1 -> val2 -> val3" for easier visualization of the results.
    /// </summary>
    /// <param name="head">The head of the linked list to print.</param>
    /// <returns>A string representing the linked list in a readable format.</returns>
    public static string PrettyPrintLinkedList(ListNode? head)
    {
        if (head == null)
            return "Empty list";

        ListNode? current = head;
        var result = new System.Text.StringBuilder();

        while (current != null)
        {
            result.Append(current.val);
            if (current.next != null)
                result.Append(" -> ");
            current = current.next;
        }

        return result.ToString();
    }
    /// <summary>
    /// Helper method created by ChatGPT to create a linked list from an array of integers. This is useful for setting up test cases without having to manually create each node and link them together.
    /// </summary>
    /// <param name="values">The array of integers to create the linked list from.</param>
    /// <returns>The head of the created linked list.</returns>
    public static ListNode? CreateLinkedList(params int[] values)
    {
        if (values.Length == 0)
            return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.Length; i++)
        {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
    /// <summary>
    /// Helper method created by ChatGPT to pretty-print an array of integers in the format "val1 -> val2 -> val3". This is useful for visualizing the contents of an array in a more readable format, especially when comparing expected and actual results in test cases.
    /// </summary>
    /// <param name="arr">The array of integers to pretty-print.</param>
    /// <returns>A string representing the array in a readable format.</returns>
    public static string PrettyPrint(int[] arr)
    {
        if (arr == null || arr.Length == 0)
            return "Empty array";

        return string.Join(" -> ", arr);
    }
    public static void Main()
    {
        var solution = new Solution();
        var l1 = CreateLinkedList(2, 4, 3) ?? new ListNode(); // 342
        var l2 = CreateLinkedList(5, 6, 4) ?? new ListNode(); // 465
        var result = solution.AddTwoNumbers(l1, l2); // 807
        Console.WriteLine($"\nResult: {PrettyPrintLinkedList(result)}\nCorrect: {PrettyPrint(new int[] { 7, 0, 8 })}\n"); // 807
    }
}
#endregion