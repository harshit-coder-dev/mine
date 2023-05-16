package com.pdf.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDto {
	
	private Integer id;
    private String ctg;
    private String sctg;
    private String quality;
    private String ptr;
    private Double qty; // Change the type to Double
    private String uom;
    private String setting_method;
    private String setting_type;

}
