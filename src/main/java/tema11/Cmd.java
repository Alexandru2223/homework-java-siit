package tema11;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;


public class Cmd {

    private static void deleteDirectory(@NotNull File file, String dirName) {
        File deletedFile = new File(String.valueOf(file.getAbsoluteFile()) +"/" + dirName);
        if(deletedFile.delete()){
            System.out.println("File succesfully deleted !");
        }
    }

    private static void createDirectory(@NotNull File file, String dirName) throws IOException {
       File newFile = new File(String.valueOf(file.getAbsoluteFile()) +"/" + dirName);
       if(!newFile.exists()) {
           if (newFile.createNewFile()) {
               System.out.println("File succesfully created !");
           }
       }
    }

    private static void listContent(File file, String fileName) throws IOException {
        if(findFiles(file,fileName)){
            File file1 = new File(fileName);
            displayContentOfCurrentDirectory(file1);
        }
    }

    private static void displayOS() {
        String os = System.getProperty("os.name");
        System.out.println(os);
    }

    private static boolean findFiles(File file, String fileName) throws IOException {
        Optional<Path> pathStream = Files.list(new File(String.valueOf(file)).toPath())
                                         .filter(path -> path.getFileName().toString().equals(fileName))
                                         .findFirst();
        if(pathStream.isPresent()) {
            System.out.println(pathStream.get());
            return true;
        } else {
            return false;
        }

    }


    private static void displayContentOfCurrentDirectory(File file) throws IOException {
        Stream<Path> pathStream = Files.list(new File(String.valueOf(file)).toPath());
        pathStream.forEach(path -> System.out.println(path.getFileName()));
    }
}
