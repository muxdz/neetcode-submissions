class MinStack {
    class Node {
        int val;
        int minVal;

        public Node(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            Node newNode = new Node(val, val);
            stack.push(newNode);
        }
        else {
            Node topNode = stack.peek();
            int min = Math.min(topNode.minVal, val);
            Node newNode = new Node(val, min);
            stack.push(newNode);
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().minVal;
    }
}
