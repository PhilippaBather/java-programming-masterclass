package org.batherphilippa.inputandoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.Iterator;
import java.util.Map;

public class MethodsOnPath {

    public static void main(String[] args) {

//        Path path = Path.of("files/tsting.txt");
//        printPathInfo(path);
//        logStatement(path);
        Path path1 = Path.of("files/test/anotherdir/testing.txt");
//        printPathInfo(path1);
        logStatement(path1);
        extraInfo(path1);

    }

    private static void printPathInfo(Path path) {
        System.out.println("Path: " + path);
        System.out.println("Filename: " + path.getFileName());
        System.out.println("Parent: " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute path: " + absolutePath);
        System.out.println("Absolute path route: " + absolutePath.getRoot());
        System.out.println("Root: " + path.getRoot());
        System.out.println("isAbsolute: " + path.isAbsolute());

        System.out.println(absolutePath.getRoot());
//        int i = 1;
//        Iterator<Path> itr = path.toAbsolutePath().iterator();
//        while(itr.hasNext()) {
//            System.out.println(".".repeat(i++) + " " + itr.next());
//        }
        // alternative method to the iterator
        int pathParts  = absolutePath.getNameCount();
        for (int i = 0; i < pathParts; i++) {
            System.out.println(".".repeat(i + 1) + " " + absolutePath.getName(i));
        }
        System.out.println("Path exists: " + Files.exists(path));
        System.out.println("--------------------------------");
    }

    private static void logStatement(Path path) {
        try {
            Path parent = path.getParent();
            if (!Files.exists(parent)) {
//                Files.createDirectory(parent);
                Files.createDirectories(parent);
            }
            Files.writeString(path, Instant.now() + " : hello file world\n", StandardOpenOption.CREATE,
            StandardOpenOption.APPEND);
        } catch(IOException ioe) {
            ioe.printStackTrace();

        }
    }

    private static void extraInfo(Path path) {
        try{
            Map<String, Object> attrs = Files.readAttributes(path, "*");
            attrs.entrySet().forEach(System.out::println);
            System.out.println(Files.probeContentType(path));
        } catch (IOException ioe){
            System.out.println("Problem getting attributes");

        }
    }
}
