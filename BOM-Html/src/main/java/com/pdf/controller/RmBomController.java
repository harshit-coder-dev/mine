package com.pdf.controller;

import com.pdf.DTO.DataDto;
import com.pdf.DTO.FromData;
import com.pdf.DTO.ProcessData;
import com.pdf.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RmBomController {

    @Autowired
    private DataService dataService;

    @GetMapping("/to")
    public ModelAndView showDataTo() {
        ModelAndView modelAndView = new ModelAndView("rm-bom");
        List<DataDto> dataList = dataService.getData();
        modelAndView.addObject("dataList", dataList);
        return modelAndView;
    }

    @GetMapping("/checkTo")
    public List<DataDto> checkDataTo(Model model) {
        List<DataDto> dataList = dataService.getData();
        model.addAttribute("dataList", dataList);
        System.out.println(dataList.size());
        return dataList;
    }

    @GetMapping("/checkFrom")
    public List<FromData> CheckFromData(Model model) {
        List<FromData> dataList = dataService.getDataFrom();
        model.addAttribute("dataList", dataList);
        System.out.println(dataList.size());
        return dataList;
    }

    @GetMapping("/from")
    public ModelAndView showDataFrom() {
        ModelAndView modelAndView = new ModelAndView("rm-bom");
        List<FromData> dataListFrom = dataService.getDataFrom();
        modelAndView.addObject("dataListFrom", dataListFrom);
        return modelAndView;
    }
    @GetMapping("/process")
    public ModelAndView showDataProcess() {
        ModelAndView modelAndView = new ModelAndView("rm-bom");
        List<ProcessData> processDataList=dataService.getDataProcess();
        modelAndView.addObject("processDataList", processDataList);
        return modelAndView;
    }

    @GetMapping("/showAllData")
    public ModelAndView showBothData() {
        List<DataDto> dataList = dataService.getData();
        List<FromData> dataListFrom = dataService.getDataFrom();
        List<ProcessData> processDataList=dataService.getDataProcess();
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
