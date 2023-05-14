package com.pdf.controller;

import com.pdf.DTO.DataDto;
import com.pdf.DTO.FromData;
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

    @GetMapping({"/to", "/"})
    public ModelAndView showData() {
        ModelAndView modelAndView = new ModelAndView("rm-bom");
        List<DataDto> dataList = dataService.getData();
        modelAndView.addObject("dataList", dataList);
        return modelAndView;
    }

    @GetMapping({"/from", "/"})
    public ModelAndView showDataFrom() {
        ModelAndView modelAndView = new ModelAndView("rm-bom");
        List<FromData> dataListFrom = dataService.getDataFrom();
        modelAndView.addObject("dataListFrom", dataListFrom);
        return modelAndView;
    }

    @GetMapping("/showBothData")
    public ModelAndView showBothData() {
        List<DataDto> dataList = dataService.getData();
        List<FromData> dataListFrom = dataService.getDataFrom();
        ModelAndView modelAndView = new ModelAndView("rm-bom");
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("dataListFrom", dataListFrom);
        return modelAndView;
    }

    @GetMapping("/xyz")
    public List<FromData> CheckFromData(Model model) {
        List<FromData> dataList = dataService.getDataFrom();
        model.addAttribute("dataList", dataList);
        System.out.println(dataList.size());
        return dataList;
    }

    @GetMapping("/abc")
    public List<DataDto> checkData(Model model) {
        List<DataDto> dataList = dataService.getData();
        model.addAttribute("dataList", dataList);
        System.out.println(dataList.size());
        return dataList;
    }

    @GetMapping("/showBothDataToFrom")
    public String showBothData(Model model) {
        List<DataDto> dataList = dataService.getData();
        List<FromData> dataListFrom = dataService.getDataFrom();
        model.addAttribute("dataList", dataList);
        model.addAttribute("dataListFrom", dataListFrom);
        return "rm-bom";
    }

    @GetMapping("myApi")
    public String myApi() {
        return "hello";
    }
}
