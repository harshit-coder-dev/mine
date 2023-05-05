package com.BOM.entity.master;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

public class RmBom extends Auditable<Integer> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_Rm_Table_id")
    private Integer fromRmTableId;

    @Column(name = "to_Rm_Table_id")
    private Integer toRmTableId;

    @Column(name = "quantity")
    private String quantity;
    @Column(name = "UOM")
    private String uom;
}
