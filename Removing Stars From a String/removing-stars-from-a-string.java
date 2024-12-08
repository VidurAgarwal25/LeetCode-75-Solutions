class Solution {
    public String removeStars(String s) {
        char[] arr = s.toCharArray(); 
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '*') {
                index--;
            } else {
                arr[index++] = arr[i];
            }
        }

        return new String(arr, 0, index);
    }
}
