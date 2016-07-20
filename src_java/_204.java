import java.util.ArrayList;

/**
 * Created by nekocode on 16/7/20.
 */
public class _204 {
    private static final int[] primes = new int[655360];
    private static int size = 6;
    private static int lastPrimes = 13;

    static {
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        primes[3] = 7;
        primes[4] = 11;
        primes[5] = 13;
        size = 6;
        lastPrimes = 13;
    }

    public int countPrimes(int n) {
        if (n > lastPrimes) {
            for (int i = lastPrimes + 1; i < n; i ++) {
                boolean is = true;
                int max = (int) Math.sqrt(n);

                for (int p = 0; p < size; p ++) {
                    int prime = primes[p];
                    if (prime > max) break;

                    if (i % prime == 0) {
                        is = false;
                        break;
                    }
                }

                if (is) {
                    primes[size++] = i;
                    lastPrimes = i;
                }
            }

            return size;
        } else {

            int count = 0;
            for (int p = 0; p < size; p ++) {
                int prime = primes[p];
                if (prime < n) count ++;
            }

            return count;
        }
    }

    public static void main(String[] args) {
//        ArrayList<Integer> primes = new ArrayList<>();
//        primes.add(2);
//        primes.add(3);
//        primes.add(5);
//        primes.add(7);
//        primes.add(11);
//        primes.add(13);
//        primes.add(17);
//
//        for (int i = 18; i != Integer.MAX_VALUE; i ++) {
//            boolean is = true;
//            for (int prime : primes) {
//                if (i % prime == 0) {
//                    is = false;
//                    break;
//                }
//            }
//            if (is) {
//                primes.add(i);
//                System.out.println(i);
//            }
//        }

        System.out.println(new _204().countPrimes(499979));
    }
}
