class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> frequency = new HashMap<>();

        int count = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char current = s.charAt(right);
            right++;
            int curLen = right-left;
            frequency.put(current, frequency.getOrDefault(current, 0)+1);
            int mostFreq = Collections.max(frequency.values());

            while ((curLen - mostFreq) > k) {
                char next = s.charAt(left);
                frequency.put(next, frequency.get(next)-1);
                mostFreq = Collections.max(frequency.values());
                left++;
                curLen--;
            }

            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }
}
