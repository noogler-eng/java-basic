package javaDemo;

import java.io.File;
import java.io.IOException;

public class FileClass {
    public static void main(String[] args) throws IOException {
        // Creating File object using single path
        File file1 = new File("yuki.txt");
        if(file1.createNewFile()){
            System.out.println("File created: " + file1.getName());
        }else{
            System.out.println("is file exists " + file1.exists());
            System.out.println("file1 already exist!");
            if(file1.delete()){
                System.out.println("file1 has been deleted");
            }else{
                System.out.println("file1 has not been deleted!");
            }
        }

        // Creating File object using parent and child strings
        File file2 = new File("c:/Users", "yuki2.txt");

        // Creating File object using parent File object and child
        File parentDir = new File("C:/Users");
        File file3 = new File(parentDir, "yuki3.txt");

        System.out.println("path1 -> " + file1.getPath());
        System.out.println("path1 -> " + file2.getPath());
        System.out.println("path1 -> " + file3.getPath());

        File file_ = new File("sharad.txt");
        System.out.println("Is File ?" + file_.isFile());
        System.out.println("Is directory ?" + file_.isDirectory());

        // Returns the list of files and directories in a directory.
        // current directory
        File dir = new File(".");
        String[] files = dir.list();
        if(files != null){
            for(String name: files){
                System.out.println("file: " + name);
            }
        }

        // Returns the file size in bytes.
        File file = new File("sharad.txt");
        System.out.println("File size: " + file.length() + "bytes");

        // Creates a single directory or multiple directories.
        File dir1 = new File("new_folder");
        File dir2 = new File("parent_dir/child_dir");
        System.out.println("Single dir created: " + dir1.mkdir());
        System.out.println("Multiple dirs created: " + dir2.mkdirs());
    }
}

/*
    ## When to Use the File Class?
    1. Use it when you need to interact with the file system—checking if files/directories exist,
    creating or deleting files, listing directory contents, etc.
    2. It acts as a foundation for many file handling operations and is frequently used with other I/O
    classes for reading or writing content.
*/