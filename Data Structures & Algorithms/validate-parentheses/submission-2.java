class Solution {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        char[] openBrackets = {'{', '(', '['};
        char[] closedBrackets = {']', ')', '}'};

        for (int i=0; i<s.length(); i++) {
            char check = s.charAt(i);

            if ((check == '{') || (check == '(') || (check == '[')) {
                open.push(check);
            }
            else {
                if (open.isEmpty()) return false;
                switch (check) {
                    case '}': {
                        char against = open.pop();
                        if (against != '{') return false;
                        break;
                    }
                    case ')': {
                        char against = open.pop();
                        if (against != '(') return false;
                        break;
                    }
                    case ']': {
                        char against = open.pop();
                        if (against != '[') return false;
                        break;
                    }
                }
            }
        }

        if (!open.isEmpty()) return false;

        return true;
    }
}
