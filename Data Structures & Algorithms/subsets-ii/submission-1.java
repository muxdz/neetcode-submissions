class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        traverse(0, nums);
        return result;
    }

    private void traverse(int start, int[] nums) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            subset.add(nums[i]);
            traverse(i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
