package org.batherphilippa.inputandoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class FilesMethods {

    public static void main(String[] args) {
        Path path = Path.of("");
        System.out.println("cwd: " + path.toAbsolutePath());

        try (Stream<Path> paths = Files.list(path)) {
            // not recursive, so won't list files within directories
            paths.map(FilesMethods::listDir)
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("__________________________________________________");

        try (Stream<Path> paths = Files.walk(path, 2)) {
            // walk is recursive if maxDepth > 1
            paths.filter(Files::isRegularFile) // remove dirs
                    .map(FilesMethods::listDir)
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("__________________________________________________");

        // note (p, attr) -> Files.isRegularFile(p) is longer form of writing the lambda expression.
        // Files can be replaced with attr as they are available
        try (Stream<Path> paths = Files.find(path, Integer.MAX_VALUE, (p, attr) -> attr.isRegularFile() && attr.size() > 300)) {
            // walk is recursive if maxDepth > 1
            paths.map(FilesMethods::listDir)
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("___________________ Directory Stream ______________________________");

        path = path.resolve(".idea"); //  change path
        // glob similar to regex; return only xml files
        try (var dirs = Files.newDirectoryStream(path,
                // alternative to the glob
                p -> p.getFileName().toString().endsWith(".xml") && Files.size(p) < 1000)) {
            dirs.forEach(d -> System.out.println(FilesMethods.listDir(d)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("___________________ Directory Stream ______________________________");

        // glob similar to regex; return only xml files
        try (var dirs = Files.newDirectoryStream(path, "*.xml")) {
            dirs.forEach(d -> System.out.println(FilesMethods.listDir(d)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static String listDir(Path path) {
        try {
            boolean isDir = Files.isDirectory(path);
            FileTime dateField = Files.getLastModifiedTime(path);
            LocalDateTime modDT = LocalDateTime.ofInstant(dateField.toInstant(), ZoneId.systemDefault());
            return "%tD %tT %-5s %12s %s".formatted(modDT, modDT, (isDir ? "<DIR>" : ""), (isDir  ? "" : Files.size(path)), path);
        } catch (IOException ioe) {
            System.out.println("Something went wrong with " + path);
            return path.toString();
        }
    }
}
