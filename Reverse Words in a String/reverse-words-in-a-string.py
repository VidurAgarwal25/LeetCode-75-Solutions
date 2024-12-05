class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        left = 0
        right = len(s) - 1

       
        while left <= right and s[left] == ' ':
            left += 1
       
        while right >= left and s[right] == ' ':
            right -= 1

        
        words = []
        word = ""

       
        for i in range(left, right + 1):
            if s[i] == ' ':
                if word:  
                    words.append(word)
                    word = ""
            else:
                word += s[i]

       
        if word:
            words.append(word)

        return ' '.join(reversed(words))
