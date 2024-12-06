class Solution(object):
    def maxVowels(self, s, k):
        vowels = set('aeiou')
        count = 0
        maxCount = 0

        for i in range(k):
            if s[i] in vowels:
                count += 1

        maxCount = count

        for r in range(k, len(s)):
            if s[r] in vowels:
                count += 1
            if s[r - k] in vowels:
                count -= 1
            maxCount = max(count, maxCount)

        return maxCount
