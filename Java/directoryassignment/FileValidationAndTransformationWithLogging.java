package Java.directoryassignment;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileValidationAndTransformationWithLogging {
    private static final Logger logger = Logger.getLogger(FileValidationAndTransformationWithLogging.class);

    public static void main(String[] args) {
        // Configure Log4j to write logs to a file
        PropertyConfigurator.configure("log4j.properties");

        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        String logFileName = "validation_log.txt";
        String errorLogFileName = "error.log";

        int validRecords = 0;
        int invalidRecords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
             BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    if (isValidRecord(line)) {
                        validRecords++;
                        String transformedRecord = transformRecord(line);
                        writer.write(transformedRecord);
                        writer.newLine();
                    } else {
                        invalidRecords++;
                        logWriter.write("Invalid Record: " + line);
                        logWriter.newLine();
                    }
                } catch (Exception e) {
                    logException(e, errorLogFileName);
                }
            }

        } catch (IOException e) {
            logException(e, errorLogFileName);
        }

        System.out.println("Validation and Transformation Complete.");
        System.out.println("Valid Records: " + validRecords);
        System.out.println("Invalid Records: " + invalidRecords);
    }

    public static boolean isValidRecord(String line) {
        try {

            String[] parts = line.split(",");
            return parts.length == 3;
        } catch (Exception e) {
            logException(e, "validation_error.log");
            return false;
        }
    }

    public static String transformRecord(String line) {
        try {

            String[] parts = line.split(",");
            return parts[2] + "," + parts[1] + "," + parts[0];
        } catch (Exception e) {
            logException(e, "transformation_error.log");
            return line; // Return the original line in case of transformation error
        }
    }

    private static void logException(Exception e, String logFileName) {
        logger.error("Exception: " + e.getMessage(), e);

        // Optionally, write the exception details to a log file
        try (BufferedWriter errorLogWriter = new BufferedWriter(new FileWriter(logFileName, true))) {
            errorLogWriter.write("Exception: " + e.getMessage());
            errorLogWriter.newLine();
            for (StackTraceElement element : e.getStackTrace()) {
                errorLogWriter.write(element.toString());
                errorLogWriter.newLine();
            }
        } catch (IOException ioException) {
            logger.error("Error writing to the error log: " + ioException.getMessage(), ioException);
        }
    }
}
