class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    int[] nums;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        used = new boolean[nums.length];
        traverse();
        return result;
    }

    private void traverse() {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i]) continue;

            perm.add(nums[i]);
            used[i] = true;

            traverse();

            perm.remove(perm.size()-1);
            used[i] = false;
        }
    }
}
