class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sChars = new HashMap<>();
        HashMap<Character, Integer> tChars = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            sChars.put(current, sChars.getOrDefault(current, 0)+1);
        }

        for (int i=0; i<t.length(); i++) {
            char current = t.charAt(i);
            tChars.put(current, tChars.getOrDefault(current, 0)+1);
        }

        if (sChars.equals(tChars)) return true;
        return false;
    }
}
