class Solution {
    HashMap<Character, String> padMap;
    List<String> result;
    String comb;
    String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        padMap = new HashMap<>();
        result = new ArrayList<>();
        comb = "";

        if (digits.isEmpty()) return result;

        padMap.put('2', "abc");
        padMap.put('3', "def");
        padMap.put('4', "ghi");
        padMap.put('5', "jkl");
        padMap.put('6', "mno");
        padMap.put('7', "pqrs");
        padMap.put('8', "tuv");
        padMap.put('9', "wxyz");

        combinations(0);
        return result;
    }

    private void combinations(int i) {
        if (i == digits.length()) {
            result.add(comb);
            return;
        }

        String set = padMap.get(digits.charAt(i));

        for (int j=0; j<set.length(); j++) {
            comb += set.charAt(j);
            combinations(i+1);
            comb = comb.substring(0, comb.length()-1);
        }
    }
}
