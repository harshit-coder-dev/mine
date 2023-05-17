package com.pdf.controller;

import com.pdf.DTO.DataDto;
import com.pdf.DTO.FromData;
import com.pdf.DTO.ProcessData;
import com.pdf.model.RmTable;
import com.pdf.repo.DataRepository;
import com.pdf.repo.RmTableRepo;
import com.pdf.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RmBomController {

    @Autowired
    private DataService dataService;

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private RmTableRepo rmTableRepo;

//    @GetMapping("/to")
//    public ModelAndView showDataTo() {
//        ModelAndView modelAndView = new ModelAndView("rm-bom");
//        List<DataDto> dataList = dataService.getData();
//        modelAndView.addObject("dataList", dataList);
//        return modelAndView;
//    }

    @GetMapping("/toSp/{id}")
    public List<Object[]> showDataSp(@PathVariable Integer id) {
        List<Object[]> dataList = dataRepository.getDataList(id);
//        System.err.println(dataList.size());
        return dataList;
    }

    @GetMapping("/checkTo/{id}")
    public ModelAndView checkDataTo(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("rm-bom");
        List<DataDto> dataList = dataService.getData(id);
        modelAndView.addObject("dataList", dataList);
        return modelAndView;
    }

    @GetMapping("/checkFrom/{id}")
    public List<FromData> CheckFromData(@PathVariable Integer id) {
        List<FromData> dataList = dataService.getDataFrom(id);
//        System.out.println(dataList.size());
        return dataList;
    }

//    @GetMapping("/from")
//    public ModelAndView showDataFrom() {
//        ModelAndView modelAndView = new ModelAndView("rm-bom");
//        List<FromData> dataListFrom = dataService.getDataFrom();
//        modelAndView.addObject("dataListFrom", dataListFrom);
//        return modelAndView;
//    }

//    @GetMapping("/process")
//    public ModelAndView showDataProcess() {
//        ModelAndView modelAndView = new ModelAndView("rm-bom");
//        List<ProcessData> processDataList=dataService.getDataProcess();
//        modelAndView.addObject("processDataList", processDataList);
//        return modelAndView;
//    }


    @GetMapping("/showAllData/{id}")
    public ModelAndView showBothData(@PathVariable Integer id) throws Exception {
        Optional<RmTable> rmTableOptional = rmTableRepo.findById(id);

        if (rmTableOptional.isEmpty()) {
            return new ModelAndView("NoData");
        }

        RmTable rmTable = rmTableOptional.get();
        String rmGroup = rmTable.getRmType().getGroup();
        if (!rmGroup.equals("SKU")) {
            return new ModelAndView("NoData");
        }

        List<DataDto> dataList = dataService.getData(id);
        List<FromData> dataListFrom = dataService.getDataFrom(id);
        List<ProcessData> processDataList = dataService.getDataProcess(id);

        ModelAndView modelAndView = new ModelAndView("rm-bom");
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("dataListFrom", dataListFrom);
        modelAndView.addObject("processDataList", processDataList);

        return modelAndView;
    }


    @GetMapping("myApi")
    public String myApi() {
        return "hello";
    }
}
