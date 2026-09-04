class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        String shortest = null;
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        int diff = 0;
        for (int i=0; i<t.length(); i++) {
            Integer num = tMap.get(t.charAt(i));
            if (num == null) {
                tMap.put(t.charAt(i), 1);
                diff++;
            }
            else {
                tMap.put(t.charAt(i), num+1);
            }
        }

        int left = 0;
        int right = 0;
        int compareDiff = 0;

        while (right < s.length()) {
            char current = s.charAt(right);
            sMap.put(current, sMap.getOrDefault(current, 0)+1);

            Integer compare = tMap.get(current);
            if ((compare != null) && (compare.equals(sMap.get(current)))) {
                compareDiff++;
            }

            while (compareDiff == diff) {
                String currentWindow = s.substring(left, right + 1);

                if (shortest == null || currentWindow.length() < shortest.length()) {
                    shortest = currentWindow;
                }
                char leftC = s.charAt(left);
                sMap.put(leftC, sMap.get(leftC)-1);

                Integer remove = tMap.get(leftC);
                if ((remove != null) && (remove > sMap.get(leftC))) {
                    compareDiff--;
                }
                left++;
            }

            right++;
        }

        return shortest == null ? "" : shortest;
    }
}
