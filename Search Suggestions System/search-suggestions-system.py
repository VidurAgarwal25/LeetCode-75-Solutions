class Solution(object):
    def suggestedProducts(self, products, searchWord):
        """
        :type products: List[str]
        :type searchWord: str
        :rtype: List[List[str]]
        """
        products.sort()
        res = []
        cur = ""

        for ch in searchWord:
            cur += ch
            
            left = self.binarySearch(products, cur, True)
            right = self.binarySearch(products, cur + '~', False)
            
            temp = []
            count = 0
            for i in range(left, right):
                temp.append(products[i])
                count += 1
                if count == 3:
                    break
            
            res.append(temp)
        
        return res
    
    def binarySearch(self, products, target, isLower):
        left, right = 0, len(products)
        while left < right:
            mid = left + (right - left) // 2
            if (products[mid] < target) if isLower else (products[mid] <= target):
                left = mid + 1
            else:
                right = mid
        return left
