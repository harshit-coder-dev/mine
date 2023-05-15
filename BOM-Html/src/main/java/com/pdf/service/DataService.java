package com.pdf.service;

import com.pdf.DTO.DataDto;
import com.pdf.DTO.FromData;
import com.pdf.DTO.ProcessData;
import com.pdf.repo.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<DataDto> getData() {
        List<Object[]> results = dataRepository.getDataList();
        // Convert the raw results into a list of DataDto objects
        System.out.println(results.size());
        List<DataDto> dataList = new ArrayList<>();
        for (Object[] row : results) {
            DataDto dataDto = new DataDto();
            dataDto.setCtg((String) row[0]);
            dataDto.setSctg((String) row[1]);
            dataDto.setQuality((String) row[2]);
            dataDto.setPtr((String) row[3]);
            dataDto.setQty((Double) row[4]);
            dataDto.setUom((String) row[5]);
            dataDto.setWeight((Double) row[6]);
            dataDto.setSetting_method((String) row[7]);
            dataDto.setSetting_type((String) row[8]);
            dataList.add(dataDto);
        }
        return dataList;
    }

    public List<FromData> getDataFrom() {
        List<Object[]> results = dataRepository.getDataListFrom();
        // Convert the raw results into a list of FromData objects
        System.out.println(results.size());
        List<FromData> fromDataList = new ArrayList<>();
        for (Object[] row : results) {
            FromData fromData = new FromData();
            fromData.setNet_wt((Double) row[0]);
            fromData.setDia_wt((Double) row[1]);
            fromData.setGross_wt((Double) row[2]);
            fromData.setDia_qty((Double) row[3]);
            fromData.setSku((String) row[4]);
            fromData.setColor((String) row[5]);
            fromData.setQuality((String) row[6]);
            fromDataList.add(fromData);
        }
        return fromDataList;
    }

    public List<ProcessData> getDataProcess() {
        List<Object[]> results = dataRepository.getProcessData();
        // Convert the raw results into a list of DataDto objects
        System.out.println(results.size());
        List<ProcessData> dataList = new ArrayList<>();
        for (Object[] row : results) {
            ProcessData dataDto = new ProcessData();
            dataDto.setCtg((String) row[0]);
            dataDto.setSctg((String) row[1]);
            dataDto.setQuality((String) row[2]);
            dataDto.setQty((Double) row[3]);
            dataDto.setUom((String) row[4]);
            dataList.add(dataDto);
        }
        return dataList;
    }

}