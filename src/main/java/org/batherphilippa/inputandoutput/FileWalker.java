package org.batherphilippa.inputandoutput;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FileWalker {

    public static void main(String[] args) {

        Path startingPath = Path.of(".."); // cur dir
        FileVisitor<Path> statsVisitor = new StatsVisitor(1);

        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static class StatsVisitor extends SimpleFileVisitor<Path>{
//        private int level; // implicitly initialised to zero as class field

        private Path initialPath = null;
        // LinkedHashMap to maintain the insertion order, so directories will be printed in order.
        private final Map<Path, Long> folderSizes = new LinkedHashMap<>();
        private int initialCount;

        private int printLevel;

        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
//            System.out.println("\t".repeat(level + 1) + file.getFileName());
            // 0L is the default value if key does not exist
            // merge takes a bi-function: first arg is the existing value in map (o = old)
            // second argument is the new value (n = new)
            // so take old value and add new value to it
            folderSizes.merge(file.getParent(), 0L, (o, n) -> o += attrs.size());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);
//            level++;
//            System.out.println("\t".repeat(level) + dir.getFileName());
            if (initialPath == null) {
                initialPath = dir;
                initialCount = dir.getNameCount();
            } else {
                int relativeLevel = dir.getNameCount() - initialCount;
                if (relativeLevel == 1) {
                    // Clear map.  Could maintain a map for full walk, but if large file tree, more efficient
                    // to keep track of one folder at a time.
                    folderSizes.clear();
                }
                folderSizes.put(dir, 0L);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Objects.requireNonNull(dir);
//            if (exc != null)
//                throw exc;
//            level--; // readjust level
            if (dir.equals(initialPath)) {
                return FileVisitResult.TERMINATE;
            }
            int relativeLevel = dir.getNameCount()  - initialCount;
            if (relativeLevel == 1) {
                folderSizes.forEach((key, value) ->  {
                    int level  = key.getNameCount() - initialCount - 1; // so as not to indent first level
                    if (level < printLevel) {
                        System.out.printf("%s[%s] - %,d bytes %n", "\t".repeat(level), key.getFileName(), value);
                    }
                });
            } else {
                long folderSize = folderSizes.get(dir);
                folderSizes.merge(dir.getParent(), 0L, (o, n) -> o += folderSize);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
