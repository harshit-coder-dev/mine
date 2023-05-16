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
	private Integer id;
    private String ctg;
    private String sctg;
    private String quality;
    private String ptr;
    private Double qty; // Change the type to Double
    private String uom;
    private Double weight; // Change the type to Double
    private String setting_method;
    private String setting_type;

    public String getSetting_method() {
        return setting_method;
    }

    public void setSetting_method(String setting_method) {
        this.setting_method = setting_method;
    }
}
