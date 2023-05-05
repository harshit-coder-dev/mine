package com.BOM.service;

import com.BOM.entity.master.*;

public interface BomService {

    String addRmBom(RmBom rmBom);
    String addRmProperty(RmProperty rmProperty);
    String addRmPropertyValue(RmPropertyValue rmPropertyValue);
    String addRmTable(RmTable rmTable);
    String addRmType(RmType rmType);
}
