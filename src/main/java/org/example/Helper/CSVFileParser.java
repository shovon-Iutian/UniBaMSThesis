package org.example.Helper;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.example.model.DataAttribute;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileParser {

    public List<String []> GetAllContents(String filePath) {
        try(CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<String []> GetContentsWithoutHeader(String filePath) {
        try(CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.skip(1);
            return reader.readAll();
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void WriteDataIntoCSV(String filePath, List<DataAttribute> contents)
    {
        try(CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            List<String[]> data = contents.stream().map(content -> new String [] { content.getFirstName(), content.getLastName(), content.getAge().toString(), content.getEmail()}).collect(Collectors.toList());
            data.forEach(d -> writer.writeNext(d, false));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AppendDataIntoCSV(String filePath, List<DataAttribute> contents)
    {
        try(CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) {
            List<String[]> data = contents.stream().map(content -> new String [] { content.getFirstName(), content.getLastName(), content.getAge().toString(), content.getEmail()}).collect(Collectors.toList());
            data.forEach(d -> writer.writeNext(d, false));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
