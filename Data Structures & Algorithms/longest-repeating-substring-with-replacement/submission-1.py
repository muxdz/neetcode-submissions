class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        hashMap = dict()
        maxLen = 0
        left = 0
        right = 0
        while right < len(s):
            freq = hashMap.get(s[right], 0)
            hashMap[s[right]] = freq+1
            
            mostFreq = max(hashMap.values())
            curLen = right-left+1

            while (curLen-mostFreq) > k:
                hashMap[s[left]] -= 1
                left += 1

                mostFreq = max(hashMap.values())
                curLen = right-left+1
            
            maxLen = max(maxLen, curLen)
            right += 1

        return maxLen
