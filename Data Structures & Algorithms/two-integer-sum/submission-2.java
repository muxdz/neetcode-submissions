class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> contains = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            contains.put(nums[i], i);
        }

        int[] found = new int[2];
        for (int i=0; i<nums.length; i++) {
            int required = target - nums[i];
            Integer index = contains.get(required);
            if (index != null && index != i) {
                found[0] = Math.min(i, index);
                found[1] = Math.max(i, index);
                break;
            }
        }

        return found;
    }
}
