class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length-k+1];

        int currentMax = -999999;
        while (right < nums.length) {
            while (right < k) {
                currentMax = Math.max(currentMax, nums[right]);
                right++;
            }
            result[right-k] = currentMax;
            if (right == nums.length) break;

            int leaving = nums[left];
            int joining = nums[right];

            if (leaving == currentMax) {
                int prevLeft = left;
                currentMax = -999999;
                while (left < right) {
                    left++;
                    currentMax = Math.max(currentMax, nums[left]);
                }
                left = prevLeft;
            }
            else {
                currentMax = Math.max(currentMax, joining);
            }

            left++;
            right++;
        }

        result[right-k] = currentMax;

        return result;
    }
}
