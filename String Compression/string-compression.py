class Solution(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        j = 0  
        i = 0 
        
        while i < len(chars):
            current_char = chars[i]
            count = 0
            
            
            while i < len(chars) and chars[i] == current_char:
                i += 1
                count += 1
            
            
            chars[j] = current_char
            j += 1
            
            
            if count > 1:
                for digit in str(count):
                    chars[j] = digit
                    j += 1
        
        return j  
