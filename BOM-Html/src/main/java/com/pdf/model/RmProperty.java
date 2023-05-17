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
@Table(name = "rm_property", schema = "master")
public class RmProperty {
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

    @Column(name = "serial_of_properties")
    private Integer serialOfProperties;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "rm_type_id_fn_key"), name = "rm_type_id")
    private RmType rmType;
    
    

}
