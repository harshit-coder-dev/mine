package com.pdf.demo;

import com.pdf.DTO.DataDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<DataDto> dataList = DataRetriever.getDataList();
        String htmlTable = HTMLGenerator.generateHTMLTable(dataList);
        System.out.println(htmlTable);
    }
}
