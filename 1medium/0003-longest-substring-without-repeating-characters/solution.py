#https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # This time use sliding window approach with a left border and a right border
        # When we have a duplicate in our substring, move left border slowly to right border
        # while also removing chars from seen and then slide right border again
        seen: set = set()
        left: int = 0
        maximum: int = 0

        # Slide right border alone
        for right in range(len(s)):

            # When we find a duplicate, slowly remove all chars left from right border from seen,
            # and shift left border to right border
            while s[right] in seen:
                seen.remove(s[left])
                left += 1

            # Add the char at right border to seen
            seen.add(s[right])

            # When the number off chars between both borders is bigger than our maximum,
            # we found a new maximum
            maximum = max(maximum, right - left + 1)

        return maximum




# Test cases
solution = Solution()
print(solution.lengthOfLongestSubstring("abcabcbb")) # Output: 3
print(solution.lengthOfLongestSubstring("bbbbb")) # Output: 1
print(solution.lengthOfLongestSubstring("pwwkew")) # Output: 3
assert solution.lengthOfLongestSubstring("abcabcbb") == 3
assert solution.lengthOfLongestSubstring("bbbbb") == 1
assert solution.lengthOfLongestSubstring("pwwkew") == 3