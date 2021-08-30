package iterables;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

import java.math.MathContext;

public class Fibonacci implements Iterable<BigDecimal> {

    public static void main (String[] args) throws InterruptedException {
        long i = 0;
        for (BigDecimal fi : new Fibonacci()) {
            System.out.print(String.format(
                "\033[1000D\033[1;38;5;157mGolden ratio, fi = %s\033[0K\033[0;0m",
                fi
            ));
            System.out.flush();
            Thread.sleep((long) (1000 * Math.pow(0.95, i++))); // 5% faster in each step
        }
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return new Iterator<>() {
            private BigInteger n = BigInteger.TWO;
            private BigInteger fib_n_2 = BigInteger.ZERO;
            private BigInteger fib_n_1 = BigInteger.ONE;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public BigDecimal next() {
                final BigInteger fib_n;
                fib_n = this.fib_n_2.add(this.fib_n_1);
                this.fib_n_2 = this.fib_n_1;
                this.fib_n_1 = fib_n;

                this.n.add(BigInteger.ONE);

                BigDecimal fib_n_1 = new BigDecimal(this.fib_n_1);
                BigDecimal fib_n_2 = new BigDecimal(this.fib_n_2);
                return fib_n_1.divide(fib_n_2, new MathContext(64));
            }
        };
    }
}
