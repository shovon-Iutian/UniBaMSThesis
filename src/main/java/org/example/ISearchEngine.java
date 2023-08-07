package org.example;

import org.example.model.DataAttribute;
import org.example.model.SearchFileDto;

import java.util.List;

public interface ISearchEngine {
    SearchFileDto GetAllData(String path);
    List<DataAttribute> SearchSingleAttribute(List<DataAttribute> data, String keyword, String value);
}
