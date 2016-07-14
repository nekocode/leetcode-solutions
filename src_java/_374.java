/**
 * Created by nekocode on 16/7/14.
 */
public class _374 {
    /* The guess API is defined in the parent class GuessGame.
       @param num, your guess
       @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
       int guess(int num); */
    int guess(int num) {
        final int goal = 100;
        if (num == goal) return 0;
        if (num < goal) return 1;
        if (num > goal) return -1;

        return 0;
    }

    public int guessNumber(int n) {
        int guessNumber = n / 2;
        int rlt = 1;
        int max = n;
        int min = 1;

        while (rlt != 0) {
            rlt = guess(guessNumber);
            switch (rlt) {
                case -1:
                    max = guessNumber;  // 最大不大于上一回的 guessNumber
                    guessNumber = guessNumber - (guessNumber - min) / 2;
                    if (max == guessNumber) guessNumber--;
                    break;

                case 1:
                    min = guessNumber;  // 最小不小于上一回的 guessNumber
                    guessNumber = guessNumber + (max - guessNumber) / 2;
                    if (min == guessNumber) guessNumber++;
                    break;

                case 0:
            }
        }

        return guessNumber;
    }

    public static void main(String[] args) {
        System.out.print(new _374().guessNumber(100));
    }
}
