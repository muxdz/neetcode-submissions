class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        dfs(0, 0);
        return result;
    }

    private void dfs(int i, int total) {
        if (total == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }

        combination.add(candidates[i]);
        dfs(i+1, total+candidates[i]);

        combination.remove(combination.size()-1);

        while (i+1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }

        dfs(i+1, total);
    }
}
