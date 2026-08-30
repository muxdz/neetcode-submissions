class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int leftMost = 0;
        for (int i=0; i<height.length; i++) {
            if (i==0) {
                maxLeft[i] = 0;
                continue;
            }

            leftMost = Math.max(leftMost, height[i-1]);
            maxLeft[i] = leftMost;
        }

        int rightMost = 0;
        for (int i=height.length-1; i>-1; i--) {
            if (i==height.length-1) {
                maxRight[i] = 0;
                continue;
            }

            rightMost = Math.max(rightMost, height[i+1]);
            maxRight[i] = rightMost;
        }

        int total = 0;
        for (int i=0; i<height.length; i++) {
            int right = maxRight[i];
            int left = maxLeft[i];

            if (height[i] >= Math.min(left,right)) continue;
            total += Math.min(left,right) - height[i];
        }

        return total;
    }
}
