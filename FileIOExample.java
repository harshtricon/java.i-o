import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIOExample {

    private static final Logger logger = Logger.getLogger(FileIOExample.class.getName());

    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";
        String dataToWrite = "This is the data to write into the file.";


        try (FileInputStream fileInputStream = new FileInputStream(inputFilePath)) {
            int content;
            System.out.println("Reading from file: " + inputFilePath);
            while ((content = fileInputStream.read()) != -1) {
                System.out.print((char) content); // Print the content of the file
            }
            System.out.println("\nFinished reading the file.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred while reading the file: " + inputFilePath, e);
        }
        
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
            fileOutputStream.write(dataToWrite.getBytes());
            System.out.println("Data written to file: " + outputFilePath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred while writing to the file: " + outputFilePath, e);
        }
    }
}
