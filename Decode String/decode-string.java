class Solution {
    public String decodeString(String s) {
        int i = 0;
        Stack<Character> stack = new Stack<>();
        
        while (i < s.length()) {
            if (s.charAt(i) == ']') {
                String temp = "";
                String rep = "";
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    rep = stack.pop() + rep;
                }
                int count = Integer.parseInt(rep);
                String repeat = "";
                for (int j = 1; j <= count; j++) {
                    repeat += temp;
                }
                for (char ch : repeat.toCharArray()) {
                    stack.push(ch);
                }
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        
        return res;
    }
}
