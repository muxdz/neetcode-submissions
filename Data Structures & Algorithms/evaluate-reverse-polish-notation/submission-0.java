class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> nums = new Stack<>();

        for (String token: tokens) {
            switch (token) {
                case "+": {
                    int num1 = Integer.parseInt(nums.pop());
                    int num2 = Integer.parseInt(nums.pop());
                    nums.push(String.valueOf(num2+num1));
                    break;
                }
                case "-": {
                    int num1 = Integer.parseInt(nums.pop());
                    int num2 = Integer.parseInt(nums.pop());
                    nums.push(String.valueOf(num2-num1));
                    break;
                }
                case "*": {
                    int num1 = Integer.parseInt(nums.pop());
                    int num2 = Integer.parseInt(nums.pop());
                    nums.push(String.valueOf(num2*num1));
                    break;
                }
                case "/": {
                    int num1 = Integer.parseInt(nums.pop());
                    int num2 = Integer.parseInt(nums.pop());
                    nums.push(String.valueOf(num2/num1));
                    break;
                }
                default: {
                    nums.push(token);
                }
            }
        }

        return Integer.parseInt(nums.pop());
    }
}
