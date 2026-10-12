class Solution {
    List<String> result = new ArrayList<>();
    String parentheses = "";
    int close = 0;
    int open = 0;

    public List<String> generateParenthesis(int n) {
        gen(n);
        return result;
    }

    private void gen(int n) {
        if (parentheses.length() == (2*n)) {
            result.add(parentheses);
            return;
        }

        if (close > open) return;

        if (open < n) {
            parentheses += "(";
            open++;
            gen(n);

            parentheses = parentheses.substring(0, parentheses.length()-1);
            open--;
        }

        if (close < open) {
            parentheses += ")";
            close++;
            gen(n);

            parentheses = parentheses.substring(0, parentheses.length()-1);
            close--;
        }
    }
}
