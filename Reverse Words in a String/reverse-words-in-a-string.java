class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;

        while (s.charAt(left) == ' ') {
            left++;
        }

        while (s.charAt(right) == ' ') {
            right--;
        }

        String res = "", word = "";

        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == ' ') {
                
                while (s.charAt(i + 1) == ' ') {
                    i++;
                }
                if (res.equals("")) {
                    res = word;
                } else {
                    res = word + " " + res;
                }
                word = "";
            } else {
                word += s.charAt(i);
            }
        }

        if (res.equals("")) {
            return word;
        }

        return word + " " + res;
    }
}
