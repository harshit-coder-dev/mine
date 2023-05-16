package com.pdf.service;

import com.pdf.DTO.DataDto;
import com.pdf.DTO.FromData;
import com.pdf.DTO.ProcessData;
import com.pdf.model.RmPropertyValue;
import com.pdf.model.RmTable;
import com.pdf.repo.DataRepository;
import com.pdf.repo.RmPropertyValueRepo;
import com.pdf.repo.RmTableRepo;
import com.pdf.repo.RmTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
	@Autowired
	private DataRepository dataRepository;

	@Autowired
	private RmTypeRepo rmTypeRepo;

	@Autowired
	private RmTableRepo rmTableRepo;

	@Autowired
	private RmPropertyValueRepo rmPropertyValueRepo;

	public DataService(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	public List<DataDto> getData(Integer id) {
		List<Object[]> results = dataRepository.getDataList(id);
		// Convert the raw results into a list of DataDto objects
		System.out.println(results.size());
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
			dataDto.setWeight(Math.round(((Double) row[7]) * 1000.0) / 1000.0);
			
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
		Double diamonWeight = 0.0;
		Double metalWeight = 0.0;
		Double findingWeight = 0.0;
		Double quantity = 0.0;
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
		fromData.setGross_wt((diamonWeight / 5) + (metalWeight + findingWeight));
		fromData.setNet_wt((metalWeight + findingWeight));
		
		fromData.setDia_qty(quantity);
		fromData.setDia_wt(diamonWeight);

		fromData.setColor(rmPropertyValueRepo.findById(rmTable.getP1()).get().getName());
		fromData.setQuality(rmPropertyValueRepo.findById(rmTable.getP2()).get().getName());

		fromDataList.add(fromData);

		return fromDataList;
	}

	public List<ProcessData> getDataProcess(Integer id) {
		List<Object[]> results = dataRepository.getProcessData(id);
		// Convert the raw results into a list of DataDto objects
		System.out.println(results.size());
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