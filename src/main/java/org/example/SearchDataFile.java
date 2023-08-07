package org.example;

import org.example.Helper.CSVFileParser;
import org.example.model.DataAttribute;
import org.example.model.SearchFileDto;

import java.util.List;

public class SearchDataFile {
    public static void main(String[] args) {
        CSVFileParser parser = new CSVFileParser();
        ISearchEngine searchEngine = new SearchEngineImpl();
        SearchFileDto csvContentData = searchEngine.GetAllData("SampleCSVFile.csv");
        if (csvContentData == null) return;
        List<DataAttribute> searchedResult = searchEngine.SearchSingleAttribute(csvContentData.Attributes, "Age", "22");
        System.out.println("The searched result:");
        searchedResult.forEach(d -> System.out.println(d.toString()));
        parser.WriteDataIntoCSV("Output.csv", searchedResult);
    }
}