class Solution {

    public String encode(List<String> strs) {
        String coded = "";

        for (String item: strs) {
            coded += item.length() + "#" + item;
        }

        return coded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            int start = j + 1;
            int end = start + length;

            decoded.add(str.substring(start, end));

            i = end;
        }

        return decoded;
    }
}
