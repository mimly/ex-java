package iterables;

import java.util.Iterator;

/**
 * Use BigDecimal instead of double for arbitrary-precision computations, @see iterables.Fibonacci
 */
public class Euler implements Iterable<Double> {

    public static void main (String[] args) throws InterruptedException {
        long i = 0;
        for (double e : new Euler()) {
            System.out.print(String.format(
                "\033[1000D\033[1;38;5;157mEuler's number, e = %.10f\033[0K\033[0;0m",
                e
            ));
            System.out.flush();
            Thread.sleep((long) (1000 * Math.pow(0.8, i++))); // 20% faster in each step
        }
        System.out.println();
    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<>() {
            private long n = 0;

            @Override
            public boolean hasNext() {
                return this.n < 1_000_000l;
            }

            @Override
            public Double next() {
                ++this.n;
                return Math.pow(1.0 + 1.0 / this.n, this.n);
            }
        };
    }
}
