package org.example;

import org.example.Helper.CSVFileParser;
import org.example.model.DataAttribute;
import org.example.model.SearchFileDto;

import java.util.ArrayList;
import java.util.List;

public class SearchEngineImpl implements ISearchEngine {

    private CSVFileParser csvFileParser = new CSVFileParser();
    /**
     * @param path
     * @return
     */
    @Override
    public SearchFileDto GetAllData(String path) {
        List<String []> contents = csvFileParser.GetContentsWithoutHeader(path);
        if (contents != null && !contents.isEmpty()) return new SearchFileDto().Create(contents, true);
        return new SearchFileDto();
    }

    /**
     * @param dataList
     * @return
     */
    @Override
    public List<DataAttribute> SearchSingleAttribute(List<DataAttribute> dataList, String keyword, String value) {
        List<DataAttribute> dataAttributeList = new ArrayList<DataAttribute>();
        if (dataList != null && !dataList.isEmpty()) {
            switch (keyword){
                case "FirstName":
                    dataList.forEach(data -> {
                        if (data.getFirstName().equals(value))
                            dataAttributeList.add(data);
                    });
                    break;
                case "LastName":
                    dataList.forEach(data -> {
                        if (data.getLastName().equals(value))
                            dataAttributeList.add(data);
                    });
                    break;
                case "Age":
                    dataList.forEach(data -> {
                        if (data.getAge().equals(Integer.parseInt(value)))
                            dataAttributeList.add(data);
                    });
                    break;
                case "Email":
                    dataList.forEach(data -> {
                        if (data.getEmail().equals(value))
                            dataAttributeList.add(data);
                    });
                    break;
                default:
                    System.out.println("Please provide the correct keyword");
            }
        }
        return dataAttributeList;
    }
}
