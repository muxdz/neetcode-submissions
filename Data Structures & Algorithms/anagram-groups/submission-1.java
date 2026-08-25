class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returnList = new ArrayList<>();
        HashMap<List<Integer>, List<String>> groups = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            String check = strs[i];
            int[] charCount = new int[26];

            for (int j=0; j<check.length(); j++) {
                char current = check.charAt(j);
                charCount[current - 'a']++;
            }

            List<Integer> key = Arrays.stream(charCount).boxed().collect(Collectors.toList());
            List<String> found = groups.get(key);
            if (found == null) {
                found = new ArrayList<>();
                found.add(check);
            }
            else found.add(check);
            groups.put(key, found);
        }

        for (List<String> group: groups.values()) {
            returnList.add(group);
        }

        return returnList;
    }
}
