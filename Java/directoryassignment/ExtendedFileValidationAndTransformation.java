package Java.directoryassignment;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.Properties;

public class ExtendedFileValidationAndTransformation {
    private static final Logger logger = Logger.getLogger(ExtendedFileValidationAndTransformation.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ExtendedFileValidationAndTransformation <directory_path>");
            System.exit(1);
        }

        // Load configuration from config.properties
        Properties config = loadConfig("config.properties");

        // Configure Log4j to write logs to the specified file
        PropertyConfigurator.configure(config.getProperty("logFilePath", "error.log"));

        String directoryPath = args[0];
        String outputFileName = "output.txt";
        String logFileName = "validation_log.txt";
        String errorLogFileName = "error.log";

        int validRecords = 0;
        int invalidRecords = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
             BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFileName))) {

            processDirectory(directoryPath, writer, logWriter, validRecords, invalidRecords, config);

        } catch (IOException e) {
            logException(e, errorLogFileName);
        }

        System.out.println("Validation and Transformation Complete.");
        System.out.println("Valid Records: " + validRecords);
        System.out.println("Invalid Records: " + invalidRecords);
    }

    public static void processDirectory(String directoryPath, BufferedWriter writer, BufferedWriter logWriter,
                                        int validRecords, int invalidRecords, Properties config) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            logger.error("Invalid directory path: " + directoryPath);
            return;
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file.getAbsolutePath(), writer, logWriter, validRecords, invalidRecords, config);
                } else if (file.getName().toLowerCase().endsWith(".txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (isValidRecord(line, config)) {
                                validRecords++;
                                String transformedRecord = transformRecord(line, config);
                                writer.write(transformedRecord);
                                writer.newLine();
                            } else {
                                invalidRecords++;
                                logWriter.write("Invalid Record in " + file.getName() + ": " + line);
                                logWriter.newLine();
                            }
                        }
                    } catch (IOException e) {
                        logException(e, config.getProperty("logFilePath", "error.log"));
                    }
                }
            }
        }
    }

    public static boolean isValidRecord(String line, Properties config) {
        String validFormat = config.getProperty("validFileFormat", "");
        return line.matches(validFormat);
    }

    public static String transformRecord(String line, Properties config) {
        String[] transformationRules = config.getProperty("transformationRules", "").split(",");
        String[] parts = line.split(",");
        StringBuilder transformedRecord = new StringBuilder();

        for (String rule : transformationRules) {
            int index = Integer.parseInt(rule);
            if (index >= 0 && index < parts.length) {
                transformedRecord.append(parts[index]).append(",");
            }
        }

        return transformedRecord.toString().replaceAll(",$", ""); // Remove the trailing comma
    }

    private static void logException(Exception e, String logFileName) {
        logger.error("Exception: " + e.getMessage(), e);

        // Optionally, write the exception details to a log file
        try (BufferedWriter errorLogWriter = new BufferedWriter(new FileWriter(logFileName, true)) {
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

    private static Properties loadConfig(String configFile) {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(configFile)) {
            properties.load(input);
        } catch (IOException e) {
            logger.error("Error loading configuration: " + e.getMessage(), e);
        }
        return properties;
    }
}
