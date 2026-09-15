class Solution {
    public int findDuplicate(int[] nums) {
        int slowInd = 0;
        int fastInd = 0;

        do {
            slowInd = nums[slowInd];
            fastInd = nums[nums[fastInd]];

        } while (fastInd != slowInd);

        int slow2 = 0;
        while (slowInd != slow2) {
            slowInd = nums[slowInd];
            slow2 = nums[slow2];
        } 

        return slow2;
    }
}
