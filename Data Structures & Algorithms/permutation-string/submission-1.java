class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for (int i=0; i<s1.length(); i++) {
            freq1.put(s1.charAt(i), freq1.getOrDefault(s1.charAt(i), 0)+1);
            freq2.put(s2.charAt(i), freq2.getOrDefault(s2.charAt(i), 0)+1);
        }

        int left = 0;
        int right = s1.length()-1;

        while (right < s2.length()-1) {
            if (freq1.equals(freq2)) return true;

            char leftC = s2.charAt(left);
            left++;
            right++;
            char rightC = s2.charAt(right);

            int remove = freq2.get(leftC);
            if (remove == 1) freq2.remove(leftC);
            else {
                freq2.put(leftC, remove-1);
            }

            freq2.put(rightC, freq2.getOrDefault(rightC, 0)+1);
        }

        if (freq1.equals(freq2)) return true;

        return false;
    }
}
