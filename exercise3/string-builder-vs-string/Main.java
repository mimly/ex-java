import java.time.Duration;
import java.time.Instant;

public class Main {

    private static final int N = 200000;

    private static long getTime(StringBuilder stringBuilder) {
        Instant start = Instant.now();
        for (int i = 0; i < Main.N; ++i) {
            stringBuilder.append('0');
        }
        Instant end = Instant.now();
        return Duration.between(start, end).getSeconds();
    }

    private static long getTime(String string) {
        Instant start = Instant.now();
        for (int i = 0; i < Main.N; ++i) {
            string += '0';
        }
        Instant end = Instant.now();
        return Duration.between(start, end).getSeconds();
    }

    public static void main (String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("By using StringBuilder class: " + Main.getTime(stringBuilder) + "s");

        String string = new String();
        System.out.println("By using String class: " + Main.getTime(string) + "s");
    }
}
