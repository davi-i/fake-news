package br.ufrn.imd.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReadCSV {

    public static final String TYPE = "text/csv";

    public static boolean isCSV(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<String[]> readCSV(String path) throws IOException, CsvException {
        var reader = new CSVReader(new FileReader(path));
        return reader.readAll();
    }
    
    public static List<String[]> readCSV(InputStream is) throws IOException, CsvException {
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            var reader = new CSVReader(fileReader);
            var list = reader.readAll();
            reader.close();
            return list;
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}