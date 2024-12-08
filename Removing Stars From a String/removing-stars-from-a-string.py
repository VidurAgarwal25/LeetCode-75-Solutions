class Solution(object):
    def removeStars(self, s):
        arr = list(s) 
        index = 0
        
        for char in s:
            if char == '*':
                index -= 1
            else:
                arr[index] = char
                index += 1
                
        return ''.join(arr[:index])
