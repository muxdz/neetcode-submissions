class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> indices = new Stack<>();

        for (int i=0; i<heights.length+1; i++) {
            if (indices.isEmpty()) indices.push(i);
            else if (i==heights.length) {
                while (!indices.isEmpty()) {
                    int index = indices.pop();
                    int height = heights[index];
                    int width = 0;

                    if (indices.isEmpty()) width = i;
                    else {
                        width = i - indices.peek()-1;
                    }

                    maxArea = Math.max(maxArea, height*width);
                }
            }
            else {
                int top = heights[indices.peek()];
                if (heights[i] >= top) {
                    indices.push(i);
                }
                else {
                    while (!indices.isEmpty() && heights[i] < heights[indices.peek()]) {
                        int index = indices.pop();
                        int height = heights[index];
                        int width = 0;

                        if (indices.isEmpty()) width = i;
                        else {
                            width = i - indices.peek()-1;
                        }

                        maxArea = Math.max(maxArea, height*width);
                    }
                    indices.push(i);
                }
            }
        }

        return maxArea;
    }
}
