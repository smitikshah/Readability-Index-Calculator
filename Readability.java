import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Smiti
 */
public class Readability {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("input.txt")));

        int spa = occurrences(' ', input) + occurrences('\n', input); // POSIX trailing newline assumed
        int per = occurrences('.', input) + occurrences('!', input)+ occurrences('?', input);
        int words = spa + 1; // Assumes no trailing space
        double wlen = (input.length() - spa - per) / (double)words;
        double senlen = (words - per) / (double)per;
        
        double RDI = 200 - 20*wlen - senlen;

        System.out.println(words + " words, " + per + " sentences, " + wlen + " avg. word length, " + senlen + " avg. sentence length.");
        System.out.println("RDI is " + RDI + ".");
    }

    public static int occurrences(char ch, String text) {
        int tot = 0;
        for (int i = 0; i < text.length(); i++)
            if (ch == text.charAt(i)) tot++;
		return tot;
    }
    
}