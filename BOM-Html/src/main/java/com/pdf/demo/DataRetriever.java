package com.pdf.demo;

import com.pdf.DTO.DataDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    public static List<DataDto> getDataList() throws SQLException {
        List<DataDto> dataList = new ArrayList<>();

        // Replace the connection URL, username, and password with your PostgreSQL database credentials
        String url = "jdbc:postgresql://localhost:5432/bom";
        String username = "postgres";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM public.rm_view";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                	Integer id = resultSet.getInt("id");
                    String category = resultSet.getString("ctg");
                    String subcategory = resultSet.getString("sctg");
                    String quality = resultSet.getString("quality");
                    String partNumber = resultSet.getString("ptr");
                    double quantity = resultSet.getInt("qty");
                    String unitOfMeasure = resultSet.getString("uom");
                    double weight = resultSet.getDouble("weight");
                    String settingMethod = resultSet.getString("setting_method");
                    String settingType = resultSet.getString("setting_type");
                    DataDto dataDto = new DataDto(id, category, subcategory, quality, partNumber, quantity,
                            unitOfMeasure, weight, settingMethod, settingType);
                    dataList.add(dataDto);
                }
            }
        }
        System.out.println(dataList.size());
        return dataList;
    }
}
