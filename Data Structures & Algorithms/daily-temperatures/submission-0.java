class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> reverse = new Stack<>();

        for (int temp: temperatures) {
            reverse.push(temp);
        }

        int[] dayDiff = new int[temperatures.length];

        for (int i=temperatures.length-1; i>0; i--) {
            int element = reverse.pop();
            int diff = 1;
            for (int j=i-1; j>-1; j--) {
                if (element > temperatures[j]) {
                    dayDiff[j] = diff;
                }
                diff++;
            }
        }

        return dayDiff;
    }
}
