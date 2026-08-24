class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> seen = new HashMap<>();

        for (int i: nums) {
            Boolean currentSeen = seen.get(i);

            if (currentSeen == null) seen.put(i, true);
            else return true;
        }

        return false;
    }
}