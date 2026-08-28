class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> numSet = new HashSet<>();
        int maxLen = 0;

        for (int num: nums) {
            numSet.add(num);
        }

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int count = 1;

            if (numSet.contains(num-1)) continue;
            while (numSet.contains(num+1)) {
                count++;
                num++;
            }

            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }
}
