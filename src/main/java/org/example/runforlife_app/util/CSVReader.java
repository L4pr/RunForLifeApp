package org.example.runforlife_app.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    public static ArrayList<String[]> readCSVFile(File file) {
        ArrayList<String[]> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                result.add(values);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }



}
