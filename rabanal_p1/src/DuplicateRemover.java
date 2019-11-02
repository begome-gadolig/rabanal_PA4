import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover {
    private HashSet<String> uniqueWords;

    public DuplicateRemover() {
        uniqueWords = new HashSet<String>();
    }

    public void remove(String dataFile) {
        FileInputStream fileByteStream = null;
        try {
            fileByteStream = new FileInputStream(dataFile);
            Scanner file = new Scanner(fileByteStream);

            while (file.hasNext()) {
                uniqueWords.add(file.next());
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

            for (String word : uniqueWords) {
                file.println(word);
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
