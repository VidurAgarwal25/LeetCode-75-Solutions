class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                boolean destroyed = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (Math.abs(asteroids[i]) > stack.peek()) {
                        stack.pop();
                    } else if (Math.abs(asteroids[i]) == stack.peek()) {
                        stack.pop();
                        destroyed = true;
                        break;
                    } else {
                        destroyed = true;
                        break;
                    }
                }
                if (!destroyed) {
                    stack.push(asteroids[i]);
                }
            }
        }
        
        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }
        
        return result;
    }
}
