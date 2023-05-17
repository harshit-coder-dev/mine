package com.pdf.service;

import com.pdf.DTO.DataDto;
import com.pdf.DTO.FromData;
import com.pdf.DTO.ProcessData;
import com.pdf.model.RmTable;
import com.pdf.repo.DataRepository;
import com.pdf.repo.RmTableRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private RmTableRepo rmTableRepo;

	public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
    DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public List<DataDto> getData(Integer id) {
        List<Object[]> results = dataRepository.getDataList(id);
        // Convert the raw results into a list of DataDto objects
//        System.out.println(results.size());
        List<DataDto> dataList = new ArrayList<>();
        for (Object[] row : results) {
            DataDto dataDto = new DataDto();
            dataDto.setId((Integer) row[0]);
            dataDto.setCtg((String) row[1]);
            dataDto.setSctg((String) row[2]);
            dataDto.setQuality((String) row[3]);
            dataDto.setPtr((String) row[4]);
            dataDto.setQty((Double) row[5]);
            dataDto.setUom((String) row[6]);
            dataDto.setWeight(Double.valueOf(decimalFormat.format(row[7])));
            dataDto.setSetting_method((String) row[8]);
            dataDto.setSetting_type((String) row[9]);
            dataList.add(dataDto);
        }
        return dataList;
    }

    public List<FromData> getDataFrom(Integer id) {
        List<Object[]> results = dataRepository.getDataListFrom(id);
        // Convert the raw results into a list of FromData objects
        System.out.println(results.size());
        List<FromData> fromDataList = new ArrayList<>();
        double diamonWeight = 0.0;
        Double metalWeight = 0.0;
        Double findingWeight = 0.0;
        double quantity = 0.0;
        for (Object[] row : results) {

            if (((String) row[1]).equals("Diamond")) {
                diamonWeight = diamonWeight + (Double) row[7];
                quantity = quantity + (Double) row[5];
            }

            if (((String) row[1]).equals("Metal")) {
                metalWeight = metalWeight + (Double) row[7];
            }

            if (((String) row[1]).equals("Findings")) {
                findingWeight = findingWeight + (Double) row[7];
            }

		}

        RmTable rmTable = rmTableRepo.findById((id)).get();

        FromData fromData = new FromData();
        fromData.setSku(rmTable.getName());

        double result = ((diamonWeight / 5) + (metalWeight + findingWeight));
        double roundedResult = Math.ceil(result * 1000) / 1000; // Round up to three decimal digits
        fromData.setGross_wt(roundedResult);

        double sum = metalWeight + findingWeight;
        double roundedSum = Math.ceil(sum * 1000) / 1000; // Round up to three decimal digits
        fromData.setNet_wt(roundedSum);

        fromData.setDia_qty(quantity);
        fromData.setDia_wt(diamonWeight);

        fromData.setColor(rmTable.getP1().getName());
        fromData.setQuality(rmTable.getP2().getName());
        System.out.println(rmTable.getInsertImage());
        fromData.setImage(rmTable.getInsertImage());

        fromDataList.add(fromData);

//        System.out.println("check"+fromDataList.get(1));
        return fromDataList;
    }

    public List<ProcessData> getDataProcess(Integer id) {
        List<Object[]> results = dataRepository.getProcessData(id);
        // Convert the raw results into a list of DataDto objects
//        System.out.println(results.size());
        List<ProcessData> dataList = new ArrayList<>();
        for (Object[] row : results) {
            ProcessData dataDto = new ProcessData();
            dataDto.setId((Integer) row[0]);
            dataDto.setCtg((String) row[1]);
            dataDto.setSctg((String) row[2]);
            dataDto.setQuality((String) row[3]);
            dataDto.setQty((Double) row[5]);
            dataDto.setUom((String) row[6]);
            dataList.add(dataDto);
        }
        return dataList;
    }

}