package Java.directoryassignment;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class TextFileAnalyzer {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // Replace with the path to your directory
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        List<File> txtFiles = new ArrayList<>();
        List<String> allWords = new ArrayList<>();
        Map<String, Integer> wordFrequency = new HashMap<>();

        processDirectory(directory, txtFiles, allWords, wordFrequency);

        System.out.println("List of .txt files:");
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getAbsolutePath());
        }

        System.out.println("Total size of .txt files: " + calculateTotalSize(txtFiles) + " bytes");

        System.out.println("Top 10 most frequent words:");
        displayTopWords(wordFrequency, 10);
    }

    public static void processDirectory(File directory, List<File> txtFiles, List<String> allWords, Map<String, Integer> wordFrequency) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file, txtFiles, allWords, wordFrequency);
                } else if (file.getName().toLowerCase().endsWith(".txt")) {
                    txtFiles.add(file);
                    extractWordsFromFile(file, allWords, wordFrequency);
                }
            }
        }
    }

    public static void extractWordsFromFile(File file, List<String> allWords, Map<String, Integer> wordFrequency) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters
                    if (!word.isEmpty()) {
                        allWords.add(word);
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long calculateTotalSize(List<File> txtFiles) {
        long totalSize = 0;
        for (File file : txtFiles) {
            totalSize += file.length();
        }
        return totalSize;
    }

    public static void displayTopWords(Map<String, Integer> wordFrequency, int topN) {
        wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
