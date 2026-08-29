class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            if ((i > 0) && (nums[i] == nums[i-1])) continue;

            int target = -nums[i];
            int j = i+1;
            int k = nums.length-1;

            while (j<k) {
                int total = nums[j] + nums[k];

                if ((k<nums.length-1) && (nums[k] == nums[k+1])) {
                    k--;
                    continue;
                }
                if ((j>i+1) && (nums[j] == nums[j-1])) {
                    j++;
                    continue;
                }
                if (total > target) {
                    k--;
                }
                else if (total < target) {
                    j++;
                }
                else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);

                    triplets.add(triplet);
                    j++;
                    k--;
                }
            }
        }

        return triplets;
    }
}
