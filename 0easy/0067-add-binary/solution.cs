public class Solution
{
    public string AddBinary(string a, string b)
    {
        // bring both strings to same length
        while (a.Length > b.Length)
        {
            b = "0" + b;
        }

        while (b.Length > a.Length)
        {
            a = "0" + a;
        }

        // add leading '0's to handle carry at the most significant bit
        a = "0" + a;
        b = "0" + b;

        int pointerA = a.Length - 1;
        int pointerB = b.Length - 1;
        int carry = 0;
        string result = "";

        // As long as pointers arent negative
        while (true)
        {
            if (pointerA < 0 || pointerB < 0)
            {
                break;
            }
            int added = ((a[pointerA] - '0') + (b[pointerB] - '0')) + carry; // use "- '0'" to convert char to int

            carry = 0;

            if (added == 2)
            {
                carry = 1;
                added = 0;
            }
            else if (added == 3)
            {
                carry = 1;
                added = 1;
            }

            result = added.ToString() + result;

            pointerA--;
            pointerB--;
        }

        // Remove leading '0' if exists
        return result[0] != '0' ? result : result.Substring(1);
    }

    public static void Main(string[] args)
    {
        Solution sol = new Solution();
        string a = "1111";
        string b = "1111";
        string result = sol.AddBinary(a, b);
        Console.WriteLine(result); // Output: "11110"
    }
}