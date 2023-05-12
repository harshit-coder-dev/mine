package com.pdf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rm_property_value", schema = "master")
public class RmPropertyValue {
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

    @Column(name = "rm_property_id")
    private Integer rmPropertyId;

    @ManyToOne
    @JoinColumn(name = "rm_property_id", insertable = false, updatable = false)
    private RmProperty rmProperty;

    @ManyToOne
    @JoinColumn(name = "rm_table_id")
    private RmTable rmTable;

}
