class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        for (char ch : searchWord.toCharArray()) {
            cur.append(ch);

            int left = binarySearch(products, cur.toString(), true);
            int right = binarySearch(products, cur.toString() + '~', false);

            List<String> temp = new ArrayList<>();
            int count = 0;
            for (int i = left; i < right && count < 3; i++) {
                temp.add(products[i]);
                count++;
            }

            res.add(temp);
        }

        return res;
    }

    private int binarySearch(String[] products, String target, boolean isLower) {
        int left = 0, right = products.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (products[mid].compareTo(target) < (isLower ? 0 : 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
