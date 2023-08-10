package org.example;

import org.example.Helper.CSVFileParser;
import org.example.model.DataAttribute;
import org.example.model.SearchFileDto;

import java.util.List;

public class SearchDataFile {
    public static void main(String[] args) {
        CSVFileParser parser = new CSVFileParser();
        ISearchEngine searchEngine = new SearchEngineImpl();
        if (args.length < 3) {
            System.out.println("Please provide the following arguments:");
            System.out.println("First argument should be either a csv file name or file path.");
            System.out.println("Second argument should be which attribute you want to searching for, i.e 'FirstName' or 'LastName'.");
            System.out.println("Third argument should be attribute value you are looking for.");
            System.out.println("Fourth argument should be either a csv output file name or file path.[Optional]");
            return;
        }
        SearchFileDto csvContentData = searchEngine.GetAllData(args[0].replace("\\", "\\\\"));
        if (csvContentData == null) {
            System.out.println("No data is found in the csv file!!!");
            return;
        }
        List<DataAttribute> searchedResult = searchEngine.SearchSingleAttribute(csvContentData.Attributes, args[1], args[2]);
        System.out.println("The searched result:");
        searchedResult.forEach(d -> System.out.println(d.toString()));
        String outputPath = args.length > 3 ? args[3].replace("\\", "\\\\") : "Output.csv";
        parser.WriteDataIntoCSV(outputPath, searchedResult);
    }
}