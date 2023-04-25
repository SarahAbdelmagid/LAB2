
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String INSECT_PATTERN = """
            (|    _                                               |    _
             ###O                                                 ###O
            |                                                    |
               \s



            \t\t |    _
                              ###O
                             |\s



                             |    _
                              ###O
                             |)""";

    public static void main(String[] args) {
        int count = countInsects("land.txt");

        System.out.println("Number of insects in the land file: " + count);
    }

    private static int countInsects(String filename) {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder fileContents = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.append(line);
            }

            String contents = fileContents.toString();
            int index = 0;
            while ((index = contents.indexOf(INSECT_PATTERN, index)) != -1) {
                count++;
                index += INSECT_PATTERN.length();
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return count;
    }
}
