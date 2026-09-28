class Solution:
    def maxArea(self, heights: List[int]) -> int:
        maxA = 0
        left = 0
        right = len(heights)-1

        while (left < right):
            area = (right-left)*min(heights[left],heights[right])
            maxA = max(area, maxA)

            if (heights[left] > heights[right]):
                right -= 1
            elif (heights[right] > heights[left]):
                left += 1
            else:
                right -= 1
                left += 1
        
        return maxA
        