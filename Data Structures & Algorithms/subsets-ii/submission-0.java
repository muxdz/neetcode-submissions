class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    List<Integer> subset = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        traverse(0);
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    private void traverse(int i) {
        if (i == nums.length) {
            set.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        traverse(i+1);

        subset.remove(subset.size()-1);
        traverse(i+1);
    }
}
