package com.pdf.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {
    private String ctg;
    private String sctg;
    private String quality;
    private String ptr;
    private Double qty; // Change the type to Double
    private String uom;
    private Double weight; // Change the type to Double
    private String settingMethod;
    private String settingType;
}
