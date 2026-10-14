class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> part = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        sub(0, 1);
        return result;
    }

    private void sub(int i, int j) {
        if (i == s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }

        if (isPalindrome(i, j)) {
            part.add(s.substring(i, j));
            sub(j, j+1);
            part.remove(part.size()-1);
        }

        if (j < s.length()) {
            sub(i, j+1);
        }     
    }

    private boolean isPalindrome(int i, int j) {
        j--;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
