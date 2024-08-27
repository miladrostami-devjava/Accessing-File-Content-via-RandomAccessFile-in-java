package com.randomaccessfile;

import java.io.RandomAccessFile;
import java.io.IOException;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        String fileName = "src/main/resources/data.dat";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            // Writing the first record
            writeRecord(raf, 0, 1234, "ali zare");
            // Writing the second record
            writeRecord(raf, 1, 5678, "pyman sorosh");

            System.out.println("Records written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeRecord(RandomAccessFile raf, int recordIndex, int id, String name) throws IOException {
        // Length of each record = 4 bytes (for ID) + 20 bytes (for name)
        final int RECORD_LENGTH = 24;

        // Position the file pointer to the specific record location
        raf.seek(recordIndex * RECORD_LENGTH);

        // Write the ID (4 bytes)
        raf.writeInt(id);

        // Write the name (20 characters, 1 character = 1 byte)
        raf.writeChars(String.format("%-20s", name));
    }
}

