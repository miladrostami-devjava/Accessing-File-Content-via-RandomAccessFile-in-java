package com.randomaccessfile;

import java.io.RandomAccessFile;
import java.io.IOException;

public class RandomAccessFileReadExample {
    public static void main(String[] args) {
        String fileName = "data.dat";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            // Reading the first record
            readRecord(raf, 0);
            // Reading the second record
            readRecord(raf, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readRecord(RandomAccessFile raf, int recordIndex) throws IOException {
        // Length of each record = 4 bytes (for ID) + 20 bytes (for name)
        final int RECORD_LENGTH = 24;

        // Move the file pointer to the start of the specified record
        raf.seek(recordIndex * RECORD_LENGTH);

        // Read the ID (4 bytes)
        int id = raf.readInt();

        // Read the name (20 characters)
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            name.append(raf.readChar());
        }

        // Display the data
        System.out.println("Record Index: " + recordIndex);
        System.out.println("ID: " + id);
        System.out.println("Name: " + name.toString().trim());
    }
}
