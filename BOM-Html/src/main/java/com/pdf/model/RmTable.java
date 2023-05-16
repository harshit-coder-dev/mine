package com.pdf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rm_table", schema = "master")
public class RmTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "name")
    private String name;

    @Column(name = "rm_type_id")
    private Integer rmTypeId;

    @Column(name = "p1")
    private Integer p1;

    @Column(name = "p2")
    private Integer p2;

    @Column(name = "p3")
    private Integer p3;

    @Column(name = "p4")
    private Integer p4;

    @Column(name = "p5")
    private Integer p5;

    @Column(name = "p6")
    private Integer p6;

    @Column(name = "p7")
    private Integer p7;

    @Column(name = "p8")
    private Integer p8;

    @Column(name = "p9")
    private Integer p9;

    @Column(name = "p10")
    private Integer p10;

    @Column(name = "p11")
    private Integer p11;

    @Column(name = "p12")
    private Integer p12;

    @Column(name = "p13")
    private Integer p13;

    @Column(name = "p14")
    private Integer p14;

    @Column(name = "p15")
    private Integer p15;

    @Column(name = "p16")
    private Integer p16;

    @Column(name = "p17")
    private Integer p17;

    @Column(name = "p18")
    private Integer p18;

    @Column(name = "p19")
    private Integer p19;

    @Column(name = "p20")
    private Integer p20;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Column(name = "insert_image")
    private String insertImage;

    @ManyToOne
    @JoinColumn(name = "rm_type_id", insertable = false, updatable = false)
    private RmType rmType;

//    @OneToMany(mappedBy = "rmTable",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<RmPropertyValue> propertyValues;
}