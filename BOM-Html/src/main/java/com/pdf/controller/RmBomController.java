package com.pdf.controller;

import com.pdf.DTO.DataDto;
import com.pdf.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RmBomController {

    @Autowired
    private DataService dataService;

    @GetMapping("/bom")
    public String getData(Model model) {
        List<DataDto> dataList = dataService.getData();
        model.addAttribute("dataList", dataList);
       System.out.println(dataList.size());
        return "rm-bom";
    }


    @GetMapping("/abc")
    public List<DataDto> checkData(Model model) {
        List<DataDto> dataList = dataService.getData();
        model.addAttribute("dataList", dataList);
        System.out.println(dataList.size());
        return dataList;
    }
    
    @GetMapping("myApi")
    public String myApi() {
    	return "hello";
    }
}
