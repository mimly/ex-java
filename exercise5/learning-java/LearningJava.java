import java.util.List;

public class LearningJava {

    private static final List<String> words = List.of("abstract", "continue", "for", "new", "switch", "assert", "default", "if", "package", "synchronized", "boolean", "do", "goto", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while", "_ (underscore)");

    private static String createStringOf(int n, char c) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main (String[] args) throws InterruptedException {
        System.out.println("\033[1;38;5;255mLearning Java...");
        for (int i = 0; i < 101; ++i) {
            System.out.print(String.format(
                "\033[1000D\033[1;38;5;%dm[%s%s] %-5s%s\033[0K\033[0;0m",
                246 + 2 * i / 20,
                LearningJava.createStringOf(i / 5, '#'),
                LearningJava.createStringOf(20 - ( i / 5 ), '-'),
                i + "%",
                i != 100 ? LearningJava.words.get(i % LearningJava.words.size()) : "Done"
            ));
            System.out.flush();
            Thread.sleep((long) (300 * Math.pow(0.7, i / 10))); // 30% faster every 10 percentage points
        }
        System.out.println();
    }
}
