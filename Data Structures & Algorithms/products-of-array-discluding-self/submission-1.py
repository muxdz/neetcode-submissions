class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left = [1 for i in range(len(nums))]
        right = [1 for i in range(len(nums))]

        for i in range(1,len(nums)):
            if i == 1:
                left[i] = nums[i-1]
                right[len(nums)-i-1] = nums[len(nums)-i]
            else:
                left[i] = left[i-1] * nums[i-1]
                right[len(nums)-i-1] = right[len(nums)-i] * nums[len(nums)-i]
        
        result = [1 for i in range(len(nums))]

        for i in range(len(nums)):
            result[i] = left[i] * right[i]

        return result

        