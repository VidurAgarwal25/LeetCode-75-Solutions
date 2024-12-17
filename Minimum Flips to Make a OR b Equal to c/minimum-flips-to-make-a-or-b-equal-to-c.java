class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bita = a & 1;
            int bitb = b & 1;
            int bitc = c & 1;
            if (bitc == 1) {
                if (bita == 0 && bitb == 0)
                    count++;
            } else {
                if (bita == 1 && bitb == 1)
                    count += 2;
                else if(bita==1||bitb==1)
                    count++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }
}