package com.BOM.service.Impl;

import com.BOM.entity.master.*;
import com.BOM.repo.*;
import com.BOM.service.BomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BomServiceImpl implements BomService {

    @Autowired
    private RmBomRepo rmBomRepo;

    @Autowired
    private RmPropertyRepo rmPropertyRepo;

    @Autowired
    private RmPropertyValueRepo rmPropertyValueRepo;

    @Autowired
    private RmTableRepo rmTableRepo;

    @Autowired
    private RmTypeRepo rmTypeRepo;

    @Override
    public String addRmBom(RmBom rmBom) {
        rmBomRepo.saveAndFlush(rmBom);
        return "Successfully added";
    }

    @Override
    public String addRmProperty(RmProperty rmProperty) {
        rmPropertyRepo.saveAndFlush(rmProperty);
        return "Successfully added";
    }

    @Override
    public String addRmPropertyValue(RmPropertyValue rmPropertyValue) {
        rmPropertyValueRepo.saveAndFlush(rmPropertyValue);
        return "Successfully added";
    }

    @Override
    public String addRmTable(RmTable rmTable) {
        rmTableRepo.saveAndFlush(rmTable);
        return "Successfully added";
    }

    @Override
    public String addRmType(RmType rmType) {
        rmTypeRepo.saveAndFlush(rmType);
        return "Successfully added";
    }
}
