package javaDemo;

/*
    ## Java Reader and Writer Classes in Java
    when working with text-based input and output (character streams), the core classes to use are Reader and Writer.

    java.lang.Object
   ├── java.io.Reader
   │       ├── BufferedReader
   │       ├── CharArrayReader
   │       ├── FilterReader
   │       ├── InputStreamReader
   │       │       └── FileReader
   │       ├── PipedReader
   │       ├── StringReader
   │
   └── java.io.Writer
           ├── BufferedWriter
           ├── CharArrayWriter
           ├── FilterWriter
           ├── OutputStreamWriter
           │       └── FileWriter
           ├── PipedWriter
           ├── PrintWriter
           ├── StringWriter


    Reader: Abstract class for reading character streams.
    Writer: Abstract class for writing character streams.

    concept of polymorphism and abstract class is followed here.....
*/

import java.io.FileWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

public class ReaderAndWriterClass {
    public static void main(String[] args){

        // 1. Reader Class Methods (With Examples)
        // printing each character....
        // StringReader is used here to simulate a stream. It reads characters one by one.
        try(Reader reader = new StringReader("Hello")){
            int ch;
            while((ch = reader.read()) != -1){
                System.out.print((char)ch);
            }
            System.out.println();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        // 2. Reads characters into an array and returns the number of characters read.
        try(Reader reader = new StringReader("Java I/O")){
            char[] buffer = new char[10];
            // this will store all the characters in buffer and return len
            int len = reader.read(buffer);
            System.out.println("Read characteristics: " + new String(buffer, 0, len));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 3. Closes the reader and releases any associated system resources.
        // here we are using try with resources so automatically reader object get out of scope...
        try(Reader reader = new StringReader("Close Example")){
            reader.read();
            System.out.println("Reader closed automatically using try-with-resources");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 4. Writer Class Methods (With Examples)
        // Writes a single character.
        try(Writer writer = new FileWriter("sharad.txt")){
            // we are writing an character
            writer.write(65);
            System.out.println("Single character written.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 5. void write(char[] cbuf)
        try(Writer writer = new FileWriter("sharad.txt")){
            char[] data = {'S', 'H', 'A', 'R', 'A', 'D'};
            writer.write(data);
            System.out.println("Character array written.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 6. Writes an entire string.
        try (Writer writer = new FileWriter("sharad.txt")) {
            writer.write("Java Writer Example");
            System.out.println("String written successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 7. Flushes the writer, forcing any buffered output to be written.
        // Flushes the writer, forcing any buffered output to be written.
        // When you use a Writer (or OutputStream) in Java, data is not always written immediately to the file.
        // Instead, it goes into an internal buffer in memory for performance reasons.
        // writer.write(...) → puts data into the buffer.
        // writer.flush() → forces Java to immediately push everything from the buffer into the actual file.
        try (Writer writer = new FileWriter("sharad.txt")) {
            writer.write("Flushed output.");
            writer.flush();
            System.out.println("Output flushed.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


/*
    ## When to Use Reader and Writer Classes?
    1. Use Reader when you want to read text data character by character or in chunks.
    2. Use Writer when writing character data to a file, memory, or other output destinations.
    3. For raw byte data like images or audio, prefer InputStream and OutputStream.
*/