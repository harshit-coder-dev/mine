package com.pdf.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FromData {
    private Double net_wt;
    private Double dia_wt;
    private Double gross_wt;
    private Double dia_qty;
    private String sku;
    private String color;
    private String quality;
}
