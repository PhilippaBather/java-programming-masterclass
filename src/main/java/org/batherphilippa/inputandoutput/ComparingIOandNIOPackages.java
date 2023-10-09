package org.batherphilippa.inputandoutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ComparingIOandNIOPackages {

    public static void main(String[] args) {
        useFile("testfile.txt");
        usePath("pathfile.txt");

    }

    // IO approach
    private static void useFile(String filename) {
        // create file
        File file = new File(filename);
        // boolean exists
        boolean fileExists = file.exists();
        // print if exists
        System.out.printf("%nFile %s %s.", filename, (fileExists ? "exists" : "does not exist"));

        // if exists print message deleting file and delete
        if(fileExists) {
            System.out.printf("%nDeleting file: %s.", filename);
            fileExists = !file.delete(); // reverse boolean logic: if deleted == true, which means fileExists == false
        }

        if(!fileExists) {
            try {
                file.createNewFile(); // returns boolean
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
            System.out.printf("%nCreated new file: %s.%n", filename);
            if (file.canWrite()) {
                System.out.println("Would write to file here.");
            }
        }
    }

    private static void usePath(String filename){
        Path path = Path.of(filename);
        boolean fileExists = Files.exists(path);
        System.out.printf("%nFile %s %s.", filename, (fileExists ? "exists" : "does not exist"));

        // if exists print message deleting file and delete
        if(fileExists) {
            System.out.printf("%nDeleting file: %s.", filename);
            try {
                Files.delete(path); // doesn't return boolean as throws an exception
                fileExists = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!fileExists) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
            System.out.printf("%nCreated new file: %s.%n", filename);
            if (Files.isWritable(path)) {
                System.out.println("Would write to file here.");
                try {
                    Files.writeString(path, """
                            Here is some data
                            for my file
                            to prove
                            that using Files class and Path class are better.
                            """ );
                    System.out.println("And can read file as well");
                    System.out.println("----------------------------");
                    Files.readAllLines(path).forEach(System.out::println);
                } catch (IOException e) {
                    System.out.println("Something went wrong");
                }
            }
        }
    }
}
