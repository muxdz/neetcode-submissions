class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    int target;
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dfs(0, 0);
        return result;
    }

    private void dfs(int i, int total) {
        if (i >= nums.length || total > target) {
            return;
        }
        if (total == target) {
            result.add(new ArrayList<>(combination));
            return;
        }

        combination.add(nums[i]);
        dfs(i, total+nums[i]);

        combination.remove(combination.size()-1);
        dfs(i+1, total);
    }
}
