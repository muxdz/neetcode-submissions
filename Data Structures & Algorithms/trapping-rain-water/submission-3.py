class Solution:
    def trap(self, height: List[int]) -> int:
        lMax = 0
        lHeight = [0] * len(height)
        rMax = 0
        rHeight = [0] * len(height)
        for i in range(len(height)):
            lMax = max(lMax, height[i])
            rMax = max(rMax, height[len(height)-1-i])
            lHeight[i] = lMax
            rHeight[len(height)-1-i] = rMax

        total = 0
        for i in range(len(height)):
            water = min(lHeight[i], rHeight[i]) - height[i]
            if water >= 0:
                total += water

        return total