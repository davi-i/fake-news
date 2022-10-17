package br.ufrn.imd.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCsv {
    public static List<String[]> readCsv(String path) throws IOException, CsvException {
        var reader = new CSVReader(new FileReader(path));
        return reader.readAll();
    }
}
