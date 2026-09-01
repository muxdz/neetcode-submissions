class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indices = new Stack<>();
        int[] dayDiff = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++) {
            while (!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]) {
                int prevIndex = indices.pop();

                dayDiff[prevIndex] = i - prevIndex;
            }
            indices.push(i);
        }

        return dayDiff;
    }
}
