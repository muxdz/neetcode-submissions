class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        out = []
        for i in range(len(nums)):
            if (i > 0 and nums[i] == nums[i-1]):
                continue

            target = -nums[i]
            left = i+1
            right = len(nums)-1

            while (left < right):
                if (right < len(nums)-1 and nums[right] == nums[right+1]):
                    right -= 1
                    continue
                elif (left > i+1 and nums[left] == nums[left-1]):
                    left += 1
                    continue

                total = nums[right] + nums[left]
                if (total == target):
                    out.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                elif (total > target):
                    right -= 1
                else:
                    left += 1

        return out