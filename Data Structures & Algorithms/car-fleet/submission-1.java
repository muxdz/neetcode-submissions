class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for (int i=0; i<position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(a[0], b[0]));
        float[] time = new float[position.length];
        Stack<Float> timeStack = new Stack<>();

        for(int i=position.length-1, j=0; i>=0; i--, j++) {
            position[j] = cars[i][0];
            speed[j] = cars[i][1];
            time[j] = (target - position[j]) / (float) speed[j];

            if (timeStack.isEmpty()) timeStack.push(time[j]);
            else {
                float next = timeStack.peek();
                if (next < time[j]) {
                    timeStack.push(time[j]);
                }
            }
        }

        return timeStack.size();
    }
}
