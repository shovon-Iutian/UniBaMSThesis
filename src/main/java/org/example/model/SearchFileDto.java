package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchFileDto {
    private static final String [] HeaderDefault  = { "Column_First", "Column_Second", "Column_Third", "Column_Fourth" };
    public String [] Header = HeaderDefault;
    public List<DataAttribute> Attributes = new ArrayList<>();
    public String Remark = "";

    public SearchFileDto() { }

    public SearchFileDto(String [] header, List<DataAttribute> attributes, String remark) {
        Header = header == null ? HeaderDefault : header;
        Attributes = attributes == null ? new ArrayList<>() : attributes;
        Remark = remark == null ? "" : remark;
    }

    public SearchFileDto Create(List<String []> dataAttributesAllList, boolean isNoHeader) {
        if (isNoHeader) return new SearchFileDto(HeaderDefault, dataAttributesAllList.stream().map(data -> new DataAttribute().Create(data)).collect(Collectors.toList()), "");
        else return new SearchFileDto(dataAttributesAllList.get(0), dataAttributesAllList.subList(1, dataAttributesAllList.size()).stream().map(data -> new DataAttribute().Create(data)).collect(Collectors.toList()), "");
    }
}
