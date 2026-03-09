// https://leetcode.com/problems/add-two-numbers/

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

public class Solution
{
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
    {
        int num1 = 0;
        // int num2 = 0;
        int digitIndex = 0; // Indicates at which index we are from right to left

        if (l1.val == 0)
        {
            num1 = 0;
        }
        else
        {
            ListNode cur = l1; ; // Current number in linked list
            while (true)
            {
                num1 += cur.val * (int)Math.Pow(10, digitIndex);
                digitIndex += 1;

                if (cur.next != null)
                {
                    cur = cur.next;
                }
                else
                {
                    break;
                }
            }
        }
        Console.WriteLine(num1);
        return new ListNode();
    }
}

public class Program
{
    public static void Main()
    {
        var solution = new Solution();
        var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        var result = solution.AddTwoNumbers(l1, l2);
        Console.WriteLine($"Result: {result?.val} -> {result?.next?.val} -> {result?.next?.next?.val}\nCorrect: 7 -> 0 -> 8\n"); // 7 -> 0 -> 8
    }
}