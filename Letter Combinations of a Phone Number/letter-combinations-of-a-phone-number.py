class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
            return []
        
        digit_to_letters = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        
        def helper(index, current):
            if index == len(digits):
                combinations.append(current)
                return
            
            for letter in digit_to_letters[digits[index]]:
                helper(index + 1, current + letter)
        
        combinations = []
        helper(0, "")
        return combinations
