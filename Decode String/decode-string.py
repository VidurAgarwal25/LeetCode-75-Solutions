class Solution(object):
    def decodeString(self, s):
        stack = []
        i = 0
        
        while i < len(s):
            if s[i] == ']':
                temp = ""
                while stack and stack[-1] != '[':
                    temp = stack.pop() + temp
                stack.pop()
                rep = ""
                while stack and stack[-1].isdigit():
                    rep = stack.pop() + rep
                count = int(rep)
                repeat = temp * count
                for ch in repeat:
                    stack.append(ch)
            else:
                stack.append(s[i])
            i += 1
        
        return "".join(stack)
