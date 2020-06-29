package tema11;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.ofEpochSecond;

public class IOMethods {
    public static void main(String[] args) throws IOException {
        File file = new File("files");
        getNamesOfDirectories(file);
        getSpecificFilesByExtension(file);
        System.out.println(checkIfFileExist(file));
        checkPermisions(file);
        checkIfItIsFileOrDirector(file);
        System.out.println(compareFiles(file));
        getModifiedDate(file);
        getSizeOfFile(file);
        readContentsToByteArray();
        readLineByLineFromFile();
        writeAndReadFromFile();
        readLFirstThreeLinesFromFile();
        findLongestWord();
    }

    public static void getNamesOfDirectories(File file) throws IOException {
        Files.list(new File(String.valueOf(file)).toPath())
             .forEach(System.out::println);
    }

    public static void getSpecificFilesByExtension(File file) throws IOException {
        Files.list(new File(String.valueOf(file)).toPath())
             .forEach(path -> {
                 if (FilenameUtils.isExtension(String.valueOf(path), "txt")) {
                     System.out.println(path.getFileName());
                 }
             });
    }

    public static boolean checkIfFileExist(File file) throws IOException {
        List<String> collect = Files.list(new File(String.valueOf(file)).toPath())
                                    .map(path -> FilenameUtils.removeExtension(path.getFileName().toString()))
                                    .collect(Collectors.toList());

        return collect.contains("output");
    }

    public static void checkPermisions(@NotNull File file) {
        System.out.println("Writable = " + file.canWrite());
        System.out.println("Readable = " + file.canRead());
    }

    public static void checkIfItIsFileOrDirector(@NotNull File file) {
        System.out.println("Director = " + file.isDirectory());
        System.out.println("File = " + file.isFile());
    }

    private static int compareFiles(File file) throws IOException {
        List<String> collect = Files.list(new File(String.valueOf(file)).toPath())
                                    .map(path -> FilenameUtils.removeExtension(path.getFileName().toString()))
                                    .collect(Collectors.toList());

        return collect.get(0).compareTo(collect.get(1));
    }

    public static void getModifiedDate(File file) {
        System.out.println(ofEpochSecond(file.lastModified(), 0, ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE));
    }

    public static void getSizeOfFile(File file) {
        System.out.println("Bytes: " + file.length());
        System.out.println("KB: " + (double) file.length() / 1000);
        System.out.println("MB: " + (double) file.length() / 1000000);
    }

    public static void readContentsToByteArray() throws IOException {
        System.out.println(Arrays.toString(FileUtils.readFileToByteArray(new File("files/test.txt"))));
    }

    public static void readLineByLineFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("files/output.txt"));
        String line = bufferedReader.readLine();
        while (line != null) {
            if (!line.equals("")) {
                System.out.println(line);
            }
            line = bufferedReader.readLine();
        }
    }

    public static void writeAndReadFromFile() throws IOException {
        Vector<String> linesArray = new Vector<>();
        File file = new File("files/test.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write("asdasdasdasdasadadasda");
        writer.newLine();
        writer.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while (line != null) {
            if (!line.equals("")) {
                linesArray.add(line);
            }
            line = bufferedReader.readLine();
        }

        linesArray.forEach(System.out::println);

    }

    public static void readLFirstThreeLinesFromFile() throws IOException {
        Files.lines(Paths.get("files/output.txt"))
             .filter(lines -> !lines.equals(""))
             .limit(3)
             .forEach(System.out::println);
    }

    public static void findLongestWord() throws IOException {
        List<String> list = Files.lines(Paths.get("files/output.txt"))
                                 .filter(lines -> !lines.equals(""))
                                 .collect(Collectors.toList());


        String text = StringUtils.join(list);
        String[] splitText = text.split("\\P{L}+");
        List<String> stringList;
        stringList = Arrays.asList(splitText);

        List<String> list1 = stringList
                .stream()
                .distinct()
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(null);

        assert list1 != null;
        list1.forEach(System.out::println);


    }
}
