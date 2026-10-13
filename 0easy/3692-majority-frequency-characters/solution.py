class Solution:
    def majorityFrequencyGroup(self, s: str) -> str:
        num_per_char = dict()
        for c in s:
            if c in num_per_char:
                num_per_char[c] += 1 
            else:
                num_per_char[c] = 1
        chars_per_freq = dict()
        for char, num in num_per_char.items():
            if num in chars_per_freq:
                chars_per_freq[num] += char
            else:
                chars_per_freq[num] = char
        max_len = max(len(value) for value in chars_per_freq.values())
        keys = [key for key, value in chars_per_freq.items() if len(value) == max_len]
        return chars_per_freq[max(keys)]
    
    
s = Solution()
result = s.majorityFrequencyGroup("aaabbbccdddde")
assert result == "ab", f"Expected \"ab\", but got {result}"
result = s.majorityFrequencyGroup("abcd")
assert result == "abcd", f"Expected \"abcd\", but got {result}"
result = s.majorityFrequencyGroup("pfpfgi")
assert result == "pf", f"Expected \"pf\", but got {result}"
