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
  
    @Column(name = "display_name")
    private String displayName;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Column(name = "insert_image")
    private String insertImage;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p1_rm_property_value_fn_key"), name = "p1")
    private RmPropertyValue p1;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p2_rm_property_value_fn_key"), name = "p2")
    private RmPropertyValue p2;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p3_rm_property_value_fn_key"), name = "p3")
    private RmPropertyValue p3;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p4_rm_property_value_fn_key"), name = "p4")
    private RmPropertyValue p4;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p5_rm_property_value_fn_key"), name = "p5")
    private RmPropertyValue p5;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p6_rm_property_value_fn_key"), name = "p6")
    private RmPropertyValue p6;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p7_rm_property_value_fn_key"), name = "p7")
    private RmPropertyValue p7;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p8_rm_property_value_fn_key"), name = "p8")
    private RmPropertyValue p8;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p9_rm_property_value_fn_key"), name = "p9")
    private RmPropertyValue p9;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p10_rm_property_value_fn_key"), name = "p10")
    private RmPropertyValue p10;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p11_rm_property_value_fn_key"), name = "p11")
    private RmPropertyValue p11;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p12_rm_property_value_fn_key"), name = "p12")
    private RmPropertyValue p12;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p13_rm_property_value_fn_key"), name = "p13")
    private RmPropertyValue p13;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p14_rm_property_value_fn_key"), name = "p14")
    private RmPropertyValue p14;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p15_rm_property_value_fn_key"), name = "p15")
    private RmPropertyValue p15;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p16_rm_property_value_fn_key"), name = "p16")
    private RmPropertyValue p16;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p17_rm_property_value_fn_key"), name = "p17")
    private RmPropertyValue p17;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p18_rm_property_value_fn_key"), name = "p18")
    private RmPropertyValue p18;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p19_rm_property_value_fn_key"), name = "p19")
    private RmPropertyValue p19;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "p20_rm_property_value_fn_key"), name = "p20")
    private RmPropertyValue p20;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "rm_type_id_fn_key"), name = "rm_type_id")
    private RmType rmType;

//    @OneToMany(mappedBy = "rmTable",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<RmPropertyValue> propertyValues;
}