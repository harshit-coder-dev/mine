package com.BOM.entity.master;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

public class RmTable extends Auditable<Integer> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
    private String p6;
    private String p7;

    @ManyToOne
    @JoinColumn(name = "rm_type_id")
    private RmType rmType;
}
