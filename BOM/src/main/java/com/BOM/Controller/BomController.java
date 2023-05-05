package com.BOM.Controller;

import com.BOM.entity.master.RmBom;
import com.BOM.service.BomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bom")
public class BomController {

    @Autowired
    private BomService bomService;

    @PostMapping("/addRmBom")
    public ResponseEntity<RmBom> createUser(@Valid @RequestBody RmBom rmBom) {
        bomService.addRmBom(rmBom);
        return new ResponseEntity<>(, HttpStatus.CREATED);
    }
}
