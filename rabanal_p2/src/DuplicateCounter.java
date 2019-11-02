import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCounter {
    private HashMap<String, Integer> wordCounter;

    public DuplicateCounter() {
        wordCounter = new HashMap<String, Integer>();
    }

    public void count(String dataFile) {
        FileInputStream fileByteStream = null;
        try {
            fileByteStream = new FileInputStream(dataFile);
            Scanner file = new Scanner(fileByteStream);

            while (file.hasNext()) {
                String word = file.next();
                if (wordCounter.containsKey(word)) {
                    wordCounter.put(word, wordCounter.get(word) + 1);
                } else {
                    wordCounter.put(word, 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } finally {
            try {
                if (fileByteStream != null) {
                    fileByteStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    public void write(String outputFile) {
        FileOutputStream fileByteStream = null;
        try {
            fileByteStream = new FileOutputStream(outputFile);
            PrintWriter file = new PrintWriter(fileByteStream);

            Set<String> uniqueWords = wordCounter.keySet();
            for (String word : uniqueWords) {
                file.println(word + " " + wordCounter.get(word));
            }
            file.flush();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } finally {
            try {
                if (fileByteStream != null) {
                    fileByteStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
