class Solution:
    def trap(self, height: List[int]) -> int:
        tallLeft = []
        tallRight = []

        for i in range(len(height)):
            tallLeft.append(height[i])
            tallRight.append(height[len(height)-i-1])
            if (i > 0):
                tallLeft[i] = max(tallLeft[i], tallLeft[i-1])
                tallRight[i] = max(tallRight[i], tallRight[i-1])

        tallRight = tallRight[::-1]

        total = 0
        for i in range(len(height)):
            if (min(tallLeft[i], tallRight[i]) - height[i]) > 0:
                total += min(tallLeft[i], tallRight[i]) - height[i]

        return total