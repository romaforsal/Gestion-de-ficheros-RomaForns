package GestionFicherosRomaForns.model;

import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Funciones {

    public static void createFolder(String fileName) {
        File folder = new File(fileName);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void createFile(String path, String fileName, String content) throws IOException {
        File file = new File(path, fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(content + System.lineSeparator());
        writer.close();
    }

    public static String[] showListFiles(String path) {
        File folder = new File(path);
        return folder.list();
    }

    public static String showFile(String path, String fileName) throws IOException {
        File file = new File(path, fileName);
        Scanner scanner = new Scanner(file);
        StringBuilder content = new StringBuilder();
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return content.toString();
    }

    public static boolean overWriteFile(String path, String fileName, String newContent) throws IOException {
        File file = new File(path, fileName);
        if (!file.exists()) return false;
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write(newContent);
        writer.close();
        return true;
    }

    public static void deleteFile(String path, String fileName) {
        File file = new File(path, fileName);
        file.delete();
    }

    public static int countChars(String path, String fileName) throws IOException {
        String content = showFile(path, fileName);
        return content.length();
    }

    public static int countWords(String path, String fileName) throws IOException {
        String content = showFile(path, fileName);
        String[] words = content.trim().split("\\s+");
        return words.length;
    }

    public static String swapWords(String path, String fileName, String oldWord, String newWord) throws IOException {
        String content = showFile(path, fileName);
        String modified = content.replace(oldWord, newWord);
        overWriteFile(path, fileName, modified);
        return modified;
    }

    public static void printPDF(String path, String fileName) throws Exception {
        String content = showFile(path, fileName);

        File pdfFile = new File(path, fileName + ".pdf");
        BufferedWriter writer = new BufferedWriter(new FileWriter(pdfFile));
        writer.write("=== CONTENIDO ===\n" + content);
        writer.close();
    }
}
