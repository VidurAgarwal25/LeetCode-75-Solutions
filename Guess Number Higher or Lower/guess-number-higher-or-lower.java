/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (guess(middle) == -1) {
                r = middle - 1;
            } else if (guess(middle) == 1) {
                l = middle + 1;
            } else
                return middle;
        }
        return -1;

    }
}