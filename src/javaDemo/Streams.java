package javaDemo;

/*
    1. What are Streams in Java?
    Handling input and output (I/O) is an essential part of Java programming.
    Whether you're reading user input, writing data to files, or processing network
    connections, Java provides a powerful I/O system using Streams.

    2. Why Do We Need Streams?
    Before Streams, handling I/O operations required dealing with low-level details like
    buffering, character encoding, and manual data transfers. Streams simplify this by:
    - Providing a consistent way to handle different types of input and output.
    - Automatically managing buffering and data conversion.
    - Enabling efficient data transfer with minimal effort.

    3. Types of Streams in Java
        A. Byte Streams (for handling binary data)
        - Uses InputStream and OutputStream classes.
        - Reads/Writes one byte at a time.
        - Example: FileInputStream, FileOutputStream.

        B. Character Streams (for handling text data)
        - Designed for reading and writing character data.
        - Uses Reader and Writer classes.
        - Example: FileReader, FileWriter.
*/

import java.io.*;

// we are implementing an interface
// The class whose objects are to be serialized must implement the Serializable interface.
// All non-serializable fields should be marked transient if they must be excluded from serialization.
// transient is any filed is not Serializable as like password....
class Student implements Serializable{
    int id;
    String name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
}

public class Streams {
    public static void main(String[] args) throws IOException {

        // Without Streams (Using Arrays)
        char[] data = {'s', 'h', 'a', 'r', 'a', 'd'};
        for(char c: data){
            System.out.print(c);
        }
        System.out.println();

        // With Streams (Using System.out)
        System.out.print("Hello");
        System.out.println();

        // Reads a single byte
        // System.in.read() reads one byte from the keyboard
        System.out.println("enter a char: ");
        int input = System.in.read();
        System.out.println();
        // typecasting from int to char
        System.out.println("You entered: " + (char) input);


        // Understanding Data Flow in Streams
        // Source → Stream → Destination
        // Input Stream: Reads data from a source (file, keyboard, network).
        // Processing: Optional transformations, like buffering or filtering.
        // Output Stream: Writes data to a destination (console, file, network).

        // Keyboard (System.in) → InputStream → Program → OutputStream → Console (System.out)
        // File (FileInputStream) → InputStream → Program → OutputStream → Network (Socket OutputStream)

        // fileInputStream
        try(FileInputStream fs = new FileInputStream("example.txt")){
            int data__;
            // Reading byte by byte
            // reading util we got -1 (termination)
            // bais.reset(); to again start from 0....
            while((data__ = fs.read()) != -1){
                System.out.print((char) data__);
            }
            System.out.println();
        }catch (Exception e){
            System.out.println("error while reading file: " + e.getMessage());
        }


        // fileOutputStream
        try(FileOutputStream fos = new FileOutputStream("sharad.txt")){
            String data___ = "hello crack the company";
            // we are dealing with bytes in reading and writing....
            fos.write(data___.getBytes());
            System.out.println("Data written successfully.");
        }catch (Exception e){
            System.out.println("error while writing into file: " + e.getMessage());
        }



        // ByteArrayInputStream
        // allows an application to read data from a byte array as an input stream.
        byte[] _data = {65, 66, 67};
        try(ByteArrayInputStream bais = new ByteArrayInputStream(_data)){
            int dataInBytes;
            while((dataInBytes = bais.read()) != -1){
                System.out.print((char) dataInBytes);
            }
            System.out.println();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        byte[] sen = "Hello sharad! how are you!".getBytes();
        byte[] buffer = new byte[5];
        try(ByteArrayInputStream bais = new ByteArrayInputStream(sen)){
            System.out.println("Bytes available: " + bais.available());
            int byteRead = bais.read(buffer, 0, buffer.length);
            // it will read until the buffer is filled
            System.out.println(new String(buffer, 0, byteRead));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        // ByteArrayOutputStream
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            baos.write(65);
            System.out.println(baos.toString());
            // to remove the pre buffered for next stuffs
            baos.reset();

            String msg = "Hello Java";
            baos.write(msg.getBytes());
            byte[] result = baos.toByteArray();
            for(byte b: result){
                System.out.print((char) b);
            }
            System.out.println();
            System.out.println(baos.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        // java I/O Streams: ObjectInputStream and ObjectOutputStream
        // Java provides ObjectInputStream and ObjectOutputStream classes for
        // serialization and deserialization of objects

        // 1. ObjectOutputStream: Used to serialize Java objects into a stream of
        // bytes and write them to an OutputStream (like a file).
        // 2. ObjectInputStream: Used to deserialize the stream of bytes into a
        // Java object from an InputStream.
        Student stud1 = new Student(123, "sharad");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("poddar.ser"))){
            oos.writeObject(stud1);
            System.out.println("Object has been serialized.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("poddar.ser"))){
            Student student = (Student) ois.readObject();
            System.out.println("ID: " + student.id);
            System.out.println("Name: " + student.name);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 1. Use when you need to save and restore the complete state of an object.
        // 2. Use for sending objects over sockets (network communication).
        // 3. Makes storing and retrieving complex data structures (like maps, lists of objects) very convenient.


        // Java I/O Streams: BufferedInputStream and BufferedOutputStream
        // BufferedInputStream and BufferedOutputStream. These classes add buffering
        // capabilities to reduce the number of disk accesses, making I/O operations more efficient

        // Buffered is just an wrapper like a cache
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("sharad.txt"))){
            int _data_;
            while((_data_ = bis.read()) != -1){
                // Print each character read from the file
                System.out.print((char) _data_);
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        // BufferedInputStream
        byte[] buffer_ = new byte[20];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("sharad.txt"))) {
            // it will return the length of bytes it will read....
            int bytesRead = bis.read(buffer_, 0, buffer_.length);
            System.out.println("Read " + bytesRead + " bytes: " + new String(buffer_, 0, bytesRead));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // BufferedOutputStream
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output1.txt"))) {
            bos.write(66);
            // Push any remaining buffered data to file
            // Ensures data is written to the file immediately
            // Flushes the buffered output to the file. Ensures no data is stuck in memory.
            bos.flush();
            System.out.println("Single byte written successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // how they enhance performance by reducing direct read/write calls to disk
        // 1. Use BufferedInputStream when reading large files or doing multiple small reads.
        // 2. Use BufferedOutputStream when writing large files or frequent small writes.
        // 3. Buffering reduces interaction with the file system, improving performance.



        // Java PrintStream Class
        // The PrintStream class in Java is a specialized output stream used to print data
        // in a human-readable format. It extends the FilterOutputStream class and adds
        // functionality to write formatted representations of objects to the output stream.

        // Why Use PrintStream?
        // 1. Printing textual representations of data
        // 2. Automatically flushing output
        // 3. Writing formatted output without needing manual conversions
        // System.out is a PrintStream object!

        try(PrintStream ps = new PrintStream("output.txt")){
            ps.print("this is additional text");
            ps.println("Line 1");
            ps.println("line 2");
            ps.printf("Name: %s, Age: %d", "Alice", 25);
            ps.write(65);

            // Manually flush to ensure data is written immediately
            ps.flush();

            System.out.println("text has been overridden");
            // automatically conn closes as using try with resources
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
