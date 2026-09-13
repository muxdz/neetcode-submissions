class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)

        maxCount = 0

        for num in nums:
            if num-1 not in numSet:
                count = 0
                while (num in numSet):
                    count += 1
                    num += 1
                maxCount = max(count, maxCount)
        
        return maxCount