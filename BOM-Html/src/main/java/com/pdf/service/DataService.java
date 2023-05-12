package com.pdf.service;

import com.pdf.DTO.DataDto;
import com.pdf.repo.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    @Autowired
    private  DataRepository dataRepository;

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
            dataDto.setSettingMethod((String) row[7]);
            dataDto.setSettingType((String) row[8]);
            dataList.add(dataDto);
        }

        return dataList;
    }
}