//package com.pdf.demo;
//
//import com.pdf.DTO.DataDto;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DBConnection {
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/bom";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "root";
//
//    public List<DataDto> getAllData() throws SQLException {
//        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.rm_view");
//
//        List<DataDto> dataList = new ArrayList<>();
//        while (resultSet.next()) {
//            DataDto dataDto = new DataDto();
//            dataDto.setCtg(resultSet.getString("Ctg"));
//            dataDto.setSctg(resultSet.getString("SCtg"));
//            dataDto.setQuality(resultSet.getString("Quality"));
//            dataDto.setPtr(resultSet.getString("Ptr"));
//            dataDto.setQty(resultSet.getDouble("Qty"));
//            dataDto.setUom(resultSet.getString("UOM"));
//            dataDto.setWeight(resultSet.getDouble("Weight"));
//            dataDto.setSettingMethod(resultSet.getString("Setting Method"));
//            dataDto.setSettingType(resultSet.getString("Setting Type"));
//            dataList.add(dataDto);
//        }
//
//        return dataList;
//    }
//}
