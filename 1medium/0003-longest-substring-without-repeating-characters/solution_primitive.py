#https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def hasDuplicates(self, s: str) -> bool:
        return len(s) != len(set(s))


    def lengthOfLongestSubstring(self, s: str) -> int:
        maximum: int = 0

        # Early return if we found a string without duplicates
        if self.hasDuplicates(s) == False:
            return len(s) 

        # First pointer
        for i in range(len(s)):

            # Define variables
            substring: str = ""
            has_duplicate: bool = False

            # Second pointer
            for j in range(i, len(s)):

                # Build our substring
                substring += s[j]

                # If substring has a duplicate after adding the new char,
                # we take the length-1 and compare to maximum we already found,
                # then exit the loop and go on with our first pointer
                if self.hasDuplicates(substring):
                    has_duplicate = True
                    if (len(substring)-1 > maximum):
                        maximum = len(substring)-1
                    break

            # If substring has no duplicate,
            # we take length and compare to maximum we already found
            if has_duplicate == False:
                if (len(substring) > maximum):
                    maximum = len(substring)

        return maximum




# Test cases
solution = Solution()
print(solution.lengthOfLongestSubstring("abcabcbb")) # Output: 3
print(solution.lengthOfLongestSubstring("bbbbb")) # Output: 1
print(solution.lengthOfLongestSubstring("pwwkew")) # Output: 3
assert solution.lengthOfLongestSubstring("abcabcbb") == 3
assert solution.lengthOfLongestSubstring("bbbbb") == 1
assert solution.lengthOfLongestSubstring("pwwkew") == 3