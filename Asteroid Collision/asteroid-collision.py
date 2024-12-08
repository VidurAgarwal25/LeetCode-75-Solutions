class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        stack = []
        for i in range(len(asteroids)):
            if asteroids[i] > 0:
                stack.append(asteroids[i])
            else:
                destroyed = False
                while stack and stack[-1] > 0:
                    if abs(asteroids[i]) > stack[-1]:
                        stack.pop()
                    elif abs(asteroids[i]) == stack[-1]:
                        stack.pop()
                        destroyed = True
                        break
                    else:
                        destroyed = True
                        break
                if not destroyed:
                    stack.append(asteroids[i])
        
        return stack
