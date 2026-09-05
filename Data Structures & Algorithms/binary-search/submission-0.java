class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int middle = (right+left)/2;
            int current = nums[middle];
            if (current == target) {
                return middle;
            }
            else {
                if (current > target) {
                    right = middle-1;
                }
                else {
                    left = middle+1;
                }
            }
        }

        return -1;
    }
}
