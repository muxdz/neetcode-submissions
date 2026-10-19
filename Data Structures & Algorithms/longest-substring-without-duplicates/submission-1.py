class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chars = set()
        left = 0
        right = 0
        maxLen = 0
        while right < len(s):
            if (s[right] in chars):
                chars.remove(s[left])
                left += 1
            else:
                chars.add(s[right])
                right += 1
            maxLen = max(maxLen, len(chars))

        return maxLen

